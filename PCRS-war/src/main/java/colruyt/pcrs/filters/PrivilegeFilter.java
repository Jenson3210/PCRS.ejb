package colruyt.pcrs.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;

/**
 * PRIVILEGE FILTER
 * @author jda1mbw
 */
public abstract class PrivilegeFilter implements Filter {
	
	private PrivilegeTypeBo minimumPrivilege;

	/**
	 * Get minimum privilege
	 * @return minimumPrivilege
	 */
	public PrivilegeTypeBo getMinimumPrivilege() {
		return minimumPrivilege;
	}

	/**
	 * Set minimum privilege
	 * @param minimumPrivilege
	 */
	public void setMinimumPrivilege(PrivilegeTypeBo minimumPrivilege) {
		this.minimumPrivilege = minimumPrivilege;
	}

	@Override
	public final void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);

		String noAccesURI = request.getContextPath() + "/accessViolation.xhtml";

		UserBo user = (UserBo) session.getAttribute("user");
		
		if(hasPrivilege(user, minimumPrivilege)) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(noAccesURI);
		}		
	}

	@Override
	public final void init(FilterConfig arg0) throws ServletException {
	}
	
	@Override
	public final void destroy() {
	}
	
	/**
	 * Check if there is a privilege
	 * @param user
	 * @param privilegeType
	 * @return boolean
	 */
	private final boolean hasPrivilege(UserBo user, PrivilegeTypeBo privilegeType) {
		boolean hasPrivilege = false;
		for (UserPrivilegeBo privilege : user.getPrivileges()) {
			if (privilege.isActive() && privilege.getPrivilegeType().equals(privilegeType)) {
				hasPrivilege = true;
			}
		}
		return hasPrivilege;
	}
}

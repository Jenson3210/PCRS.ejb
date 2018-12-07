import "babel-polyfill";
import {
	fixTable,
	handleToggle
} from './components/tables.js';
import '@fortawesome/fontawesome';
import {tooltip} from './components/tooltip';
import {filters} from './components/filters';
import {search} from './components/search';
import {navigation} from './components/navigation';

filters();
if(document.querySelector('.table')) {
	fixTable(document.querySelector('.table'));
	handleToggle(document.querySelector('.table'));
}
if(document.querySelector('.table__action--comment')) {
	tooltip('.table__action--comment');
}
if(document.querySelector('.facet-menu__item--tippy')) {
	tooltipFacetmenu('.facet-menu__item--tippy');
}
if(document.querySelector('._inputTags')) {
	search('._inputTags');
}
navigation();

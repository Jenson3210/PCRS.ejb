import { AlertType } from '../alert-type.enum';

export interface IAlert {
    type: AlertType;
    message: string;
  }
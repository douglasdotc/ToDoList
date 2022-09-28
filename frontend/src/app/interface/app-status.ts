import { DataStatus } from "../enum/data-status.enum";

// This interface defines the statis of the entire frontend application at any moment.
export interface AppStatus<T> {
  dataStatus: DataStatus;
  appData?: T;
  error?: string;
}

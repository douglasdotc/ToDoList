import { Board } from "./board";

// corresponses to the http response from backend
export interface CustomResponse {
  timeStamp: Date;
  statusCode: number;
  httpStatus: string;
  reason: string;
  message: string;
  devMessage: string;
  data: {boards?: Board[], board?: Board};
}

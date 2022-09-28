export interface Board {
  boardId: number;
  title: string;
  informations: string;
  createdAt: Date;
  lastEditedAt: Date;
  liveTimeDay: number;
  // items: Set<Item>();
}

export interface Todo {
  id: number;
  text: string;
  completed: boolean;
}

export interface CreateTodoRequest {
  text: string;
  completed?: boolean;
}

export interface UpdateTodoRequest {
  id: number;
  text?: string;
  completed?: boolean;
}

export interface TodoStats {
  total: number;
  completed: number;
  pending: number;
  completionRate: string;
}

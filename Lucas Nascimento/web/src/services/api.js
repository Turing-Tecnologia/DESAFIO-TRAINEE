import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json',
  },
});

export const createUser = (user) => api.post('/users', { ...user });

export const loginUser = (user) => api.post('/auth', { ...user });

export const getUserByToken = (token) =>
  api.get('/users/me', {
    headers: {
      'X-AUTH-TOKEN': token,
    },
  });

export const updateUser = (user) => api.patch(`/users/${user.id}`, { ...user });

export const createTask = (task, userId) =>
  api.post(`/users/${userId}/tasks`, { ...task });

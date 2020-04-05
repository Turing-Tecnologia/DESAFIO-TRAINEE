const KEY = 'X-AUTH-TOKEN';

export const signInToken = (token) => localStorage.setItem(KEY, token);

export const getToken = () => localStorage.getItem(KEY);

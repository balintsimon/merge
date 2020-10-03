// TODO: revise endpoints
const SERVER_URL = "http://localhost:8762";
export const API_SCHEDULE_URL = `${SERVER_URL}/moviecatalog/schedule`;
export const API_SHOW_URL = `${SERVER_URL}/moviecatalog/show`;
export const API_ROOM_URL = `${SERVER_URL}/cinema/room`;
export const API_RESERVATION_URL = `${SERVER_URL}/booking/reservation`;
export const API_WATCHLIST = `${SERVER_URL}/watchlist`;
export const API_AUTHENTICATION = `${SERVER_URL}/auth`;

export const API_URL_MOVIE = "https://api.themoviedb.org/3/movie/"
export const API_URL_PERSON = "https://api.themoviedb.org/3/person/"

export const API_URL_PICTURE = "https://image.tmdb.org/t/p/"

export const IMDB_URL = "https://www.imdb.com/title/";
export const IMDB_ACTOR_URL = "https://www.imdb.com/name/";

export const API_KEY = process.env.REACT_APP_API_KEY;

export const FREE_SEAT_CLASS =  "fa-square-o";
export const OCCUPIED_SEAT_CLASS = "fa-square";
export const OWN_RESERVED_SEAT_CLASS = "fa-plus-square";

export const IMAGE_SIZES = {
  backdrop_sizes: ["w300", "w780", "w1280", "original"],
  logo_sizes: ["w45", "w92", "w154", "w185", "w300", "w500", "original"],
  poster_sizes: ["w92", "w154", "w185", "w342", "w500", "w780", "original"],
};

export const DAYS = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

export const REACTOR_YELLOW = "#e6b31e";

export const GET_CONFIG = {
  headers: {
    Authorization: `Bearer ${localStorage.getItem("token")}`,
    // username: `${localStorage.getItem("username")}`,
  },
};

export const POST_CONFIG = {
  "Content-Type": "application/json",
  Authorization: `Bearer ${localStorage.getItem("token")}`,
  // username: `${localStorage.getItem("username")}`,
};
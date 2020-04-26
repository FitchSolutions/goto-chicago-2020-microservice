let host = 'http://localhost';

let userserviceport = 9000;

let calendarserviceport = 9001;

let calendarServiceHost = host + ':' + calendarserviceport;
let userServiceHost = host + ':' + userserviceport;

export { userServiceHost, calendarServiceHost };
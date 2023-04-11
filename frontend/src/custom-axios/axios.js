import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:9091/api',
    headers:{
        'Access-Control-Allow-Origin' : '*'
    }

})

//za da mozeme da ja pristapime od nadvor
export default instance;

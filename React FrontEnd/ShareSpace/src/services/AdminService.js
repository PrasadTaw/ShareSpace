import axios from 'axios';
const baseUrl="http://localhost:8080";

class AdminService{
    checkLogin(user){
        return axios.post(baseUrl+"/admin/login",user)
    }
}

export default new AdminService();
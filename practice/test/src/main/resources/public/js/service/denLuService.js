app.service("denLuService",function ($http) {
    this.denLu=function (name,password) {
        return $http.post("../test2?username="+name+"&password="+password);
    }

    this.denLu2=function (entity) {
        return $http.post("../test2",entity);
    }

    this.sendCode=function (phone) {
        return $http.get("../sendCode?phone="+phone);
    }

    this.zhuCe=function (phone,code,entity) {
        return $http.post("../zhuCe?phone="+phone+"&code="+code,entity);
    }
})
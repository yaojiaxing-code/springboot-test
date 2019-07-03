app.controller("denLuController",function ($scope,denLuService) {
    $scope.denLu=function () {
        //denLuService.denLu($scope.username,$scope.password)
        denLuService.denLu2($scope.entity)
            .success(function (response) {
            alert(response["res"]);
            if(response["res"]){
                //location.href="http://localhost:8088/hello1.html"
                location.href="http://denlu.test.cn:8088/hello1.html"
            }else {
                //location.href="http://localhost:8088/Hello.html"
                //location.href="http://192.168.1.102:8088/Hello.html"
                location.href="http://denlu.test.cn:8088/Hello.html"
            }
        })
    }

    $scope.sendCode=function () {
        denLuService.sendCode($scope.phone).success(function (response) {

        })
    }

    $scope.zhuCe=function () {
        denLuService.zhuCe($scope.phone,$scope.code,$scope.entity)
            .success(function (response) {
            if(response["res"]=="badCode"){
                alert("验证码错误！");
            }
            if(response["res"]=="badUser"){
                alert("用户名已存在！");
            }
        })
    }
})
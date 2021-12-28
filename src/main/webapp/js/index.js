$(function () {
    $("#loginIndexName").html(sessionStorage.getItem("loginName"));
    console.log(sessionStorage.getItem("loginName"));
});
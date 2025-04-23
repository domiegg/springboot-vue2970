const base = {
    get() {
        return {
            url : "http://localhost:8080/shequyiliaobaojianjiankong/",
            name: "shequyiliaobaojianjiankong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shequyiliaobaojianjiankong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "社区医疗保健监控系统"
        } 
    }
}
export default base

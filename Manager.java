public class Manager {
    private String account;
    private String password;

    public Manager(){}
    public Manager(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void managerLogin(String name,String password){
        //看参数password与文件中账号为参数name对应的密码是否一致
    }

    //经理-影片管理-列出所有正在上映影片的信息
    public void list(){
        //在影片文件中输出所有影片的信息
        System.out.println("所有的影片的信息为:.....");
    }
    //经理-影片管理-添加影片的信息
    public void addMovie(Movie movie){
        //将影片添加到影片文件中去
        System.out.println("添加影片成功！！！");
    }

    //经理-影片管理-修改电影的信息
    public void changeMovie(String movieName){
        //拿到changeMovie在影片文件中去修改影片的相关信息
        System.out.println("修改影片信息成功！！！");
    }


    //经理-影片管理-删除影片的信息
    public void deleteMovie(String movieName){
        //去文件中删除影片
        System.out.println("删除影片成功！！！");
    }

    //经理-排片管理-增加场次
    public void addChangCi(int Changci){
        //到影片场次文件中找到目标场次changCi，然后对于电影的时间，价格进行增加
        System.out.println("增加场次成功！！！");
    }

    //经理-排片管理-修改场次
    public void changeChangCi(int ChangCi){
        //到影片场次文件中找到目标场次changCi，然后对于电影的时间，价格进行修改
        System.out.println("修改场次成功！！！");
    }



    //经理-排片管理-删除场次
    public void deleteChangCi(int changCi){
        //到影片场次文件中找到目标场次changCi，然后对于电影的时间，价格进行删除
        System.out.println("删除场次成功！！！");
    }

    public void listChangCi(){
        //在场次文件中输出所有场次信息
    }







}


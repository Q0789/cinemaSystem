public class Receptionist {
    private String account;
    private String password;
    //构造方法
    public Receptionist(){}

    public Receptionist(String account, String password) {
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

    //登录
    public void receptionistLogin(String account,String password){
        //看参数password与文件中账号为参数name对应的密码是否一致
        System.out.print("登录成功！！！");
    }
    //列出所有正在上映影片的信息
    public void allOnlist(){
        //将上映影片文件中的影片输出出来
        System.out.println("所有上映影片的信息如下：");
    }
    //列出所有影片的场次信息
    public void onlist(){
        //将文件中的所有影片的场次信息输出出来
        System.out.println("所有影片的场次信息如下：");
    }
    //列出指定电影和场次信息
    public void movieAndChangci(String movieName){
        //根据电影名称movieName在文件中找到座位信息，并输出
        System.out.println("该指定影片的场次座位信息信息如下：");
    }

    //售票
    public void sellTicket(String title,String changCi,String user,String price){
        //根据传入的参数信息，在文件中找到电影票的信息，并输出
        System.out.println("电影票的信息如下：");
    }

}

import java.util.Random;

public class Admin {
    private String account;
    private String password;

    //构造方法
    public Admin(){}
    public Admin(String account, String password) {
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
    public void adminLogin(String account,String password){
        //看参数password与文件中账号为参数name对应的密码是否一致
    }

    //修改密码
    public void changePassword(String password){
        //在管理员账号密码文件中将密码修改为新密码
    }
    //重置用户密码
    public void resetUserPassword(String account){
        //先生成一个随机密码，并且需要满足我们的密码要求：密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合。
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        int length = 10; // 密码长度
        //随机密码password
        StringBuilder newPassword = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            newPassword.append(characters.charAt(index));
        }
        System.out.println("已生成随机密码:"+newPassword);
        //在用户文件中找到账号account，然后将对应的密码改为新密码newPassword
    }
    //列出所有用户信息
    public void list(){
        //在用户文件中将所有的用户信息打印输出
        System.out.println("所有用户信息如下：....");
    }
    //删除用户信息
    public void deleteUserInformation(String userName){
        //在用户信息文件中通过参数userName找到目标用户，然后删除用户信息即可
        System.out.println("该用户信息已删除");
    }
    //查询用户信息
    public void findUserInformation(String userName){
        //在用户信息文件中通过参数userName找到目标用户，然后输出该用户的用户信息即可
        System.out.println("该用户的信息如下：....");
    }
}

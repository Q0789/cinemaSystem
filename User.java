import javax.jws.soap.SOAPBinding;
import java.util.Random;

public class User {

        private int userId;//用户ID
        private String userName;//用户名

        private String userPassword;
        private String userLevel;//用户级别
        private String registrationDate;//用户注册时间
        private double totalAmountSpent;//用户累计消费总金额
        private int totalNumberOfPurchases;//用户累计消费次数
        private String phoneNumber;//用户手机号
        private String email;//用户邮箱

        //构造方法
        public User(){

        }

        public User(int userId, String userName, String userPassword,String userLevel, String registrationDate, double totalAmountSpent, int totalNumberOfPurchases, String phoneNumber, String email) {
            this.userId = userId;
            this.userName = userName;
            this.userPassword = userPassword;
            this.userLevel = userLevel;
            this.registrationDate = registrationDate;
            this.totalAmountSpent = totalAmountSpent;
            this.totalNumberOfPurchases = totalNumberOfPurchases;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        //setter和getter方法
        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(String userLevel) {
            this.userLevel = userLevel;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }

        public double getTotalAmountSpent() {
            return totalAmountSpent;
        }

        public void setTotalAmountSpent(double totalAmountSpent) {
            this.totalAmountSpent = totalAmountSpent;
        }

        public int getTotalNumberOfPurchases() {
            return totalNumberOfPurchases;
        }

        public void setTotalNumberOfPurchases(int totalNumberOfPurchases) {
            this.totalNumberOfPurchases = totalNumberOfPurchases;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        //用户的注册功能
        public void userRegister(String userName,String userPassword){
            //将用户的注册信息：账号和密码存入到文件中去
        }

        //用户的登录功能
        //注意当五次输入密码错误后就锁定账户

        public void userLogin(String userName_,String userPassword_){
            //判断这个账号在文件中对于的密码是否与传入的密码的一致性。
            //当文件中的账号和密码相匹配时，返回true，否则返回false(因为文件相关操作不会写，所以返回值暂时定为void，让程序编译不报错)

        }


        //修改密码
        public void userChangePassword(String userPassword__){
            //将该用户对象在文件中将相应的密码进行改变
        }

        //忘记密码
        public void userForgetPassword(String userGetName,String userGetEmail){
            //先生成一个随机密码，并且需要满足我们的密码要求：密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合。
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
            int length = 10; // 密码长度
            //随机密码password
            StringBuilder password = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                password.append(characters.charAt(index));
            }
            //将随机密码password发送到所给邮箱中

            //在文件中找到所给用户名的对应的密码，改为我们的随机密码password
        }

        //用户-购物管理-查看所有电影放映信息
        public  void list(){
                //将存放在文件中的所有电影都输出出来
        }

        //用户-购物管理-查看指定电影放映信息
        public void onMovie(String movieName){
            //在文件中根据电影的名字movieName来将电影的所有信息打印输出

        }

        //用户-购物管理-购票
        public  void buyTicket(int changCi){
            //在文件中找到场次changCi对应的座位二维数组arr
            //将二维数组的相关信息传递给SeatBookingSystem类中的二维数组中，然后进行购票操作
        }

        //用户-购物管理-付账
        public void giveMoney(int cinemaID) {

            //将该电影票ID存入到该用户的付款信息里面,同时在文件中给该用户增加相应的购票历史信息：时间、购买的电影票信息。
        }

        //用户-购物管理-取票
        public void getTicket(){
            //在文件中找到该用户的付款信息中的电影票ID，拿到这个ID即可取票
        }









}




import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("-----欢迎使用用户管理系统-----");
            System.out.println("1.用户");
            System.out.println("2.经理");
            System.out.println("3.管理员");
            System.out.println("4.前台");
            System.out.println("5.退出系统");
            System.out.print("请选择你的角色(输入对应角色前面的数字)： ");
            Scanner scanner = new Scanner(System.in);

            //用户可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
            boolean validInput = false;
            int number = 0;
            while (!validInput) {
                try {
                    number = Integer.parseInt(scanner.nextLine());
                    if (number >= 1 && number <= 5) {
                        validInput = true;
                    } else {
                        throw new Exception("你必须输入1，2，3，4，5这五个数字中的一个，请重新输入：");
                    }
                } catch (Exception e) {
                    System.out.print("你必须输入1，2，3，4，5这五个数字中的一个，请重新输入：");
                }
            }

            switch (number) {
                case 1:
                    //用户模块
                    boolean isUser = false;
                    while (!isUser) {
                        System.out.println("-----欢迎来到用户模块-----");
                        User user = new User();
                        System.out.println("1.注册（用户名长度不少于五个字符，密码长度大于 8 个字符，必须是大小写字母、数字和标点符号的组合）");
                        System.out.println("2.登录");
                        System.out.println("3.密码管理");
                        System.out.println("4.购票管理");
                        System.out.println("5.退出用户页面");
                        System.out.print("请选择你要执行的功能(输入对应功能前面的数字)：");
                        //用户模块的选择中可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                        boolean validInput1 = false;
                        int number1 = 0;
                        while (!validInput1) {
                            try {
                                number1 = Integer.parseInt(scanner.nextLine());
                                if (number1 >= 1 && number1 <= 5) {
                                    validInput1 = true;
                                } else {
                                    throw new Exception("你必须输入1，2，3，4，5这五个数字中的一个，请重新输入：");
                                }
                            } catch (Exception e) {
                                System.out.print("你必须输入1，2，3，4，5这五个数字中的一个，请重新输入：");
                            }
                        }

                        //用户选择了五个功能中的一个
                        switch (number1) {
                            case 1:
                                //用户-注册功能
                                //用户的注册需要用户名和密码
                                String userName = null;
                                boolean isValueName = false;
                                //输入用户名，同时对于用户名的正确与否进行判断
                                System.out.println("请输入用户的用户名(不少于5个字符)");
                                while (!isValueName) {
                                    try {
                                        userName = scanner.nextLine();
                                        if (userName.length() >= 5) {
                                            isValueName = true;
                                        } else {
                                            throw new Exception("输入的用户名的长度要求不少于5个字符，请重新输入：");
                                        }
                                    } catch (Exception e) {
                                        System.out.print("输入的字符串长度要求不少于五个字符,请重新输入：");
                                    }
                                }

                                System.out.println("请输入用户的密码（密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合）");
                                boolean isValuePassword = false;
                                String userPassword = null;
                                while (!isValuePassword) {
                                    try {
                                        userPassword = scanner.nextLine();
                                        // 定义正则表达式
                                        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
                                        // 创建 Pattern 对象
                                        Pattern p = Pattern.compile(pattern);
                                        // 创建 Matcher 对象
                                        Matcher m = p.matcher(userPassword);
                                        if (m.matches()) {
                                            isValuePassword = true;
                                        } else {
                                            throw new Exception("输入的密码要求密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合，请重新输入：");
                                        }
                                    } catch (Exception e) {
                                        System.out.print("输入的密码要求密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合，请重新输入：");
                                    }
                                }
                                user.userRegister(userName, userPassword);
                                System.out.println("注册成功!!!");
                                break;
                            case 2:
                                //用户-登录功能
                                //用户的登录需要用户名和密码
                                //可以尝试登录五次
                                //for (int i = 0; i < 5; i++) {
                                    String userName_ = null;
                                    String userPassword_ = null;
                                    boolean isValueName_ = false;
                                    while (!isValueName_) {
                                        //输入用户名和密码，同时对于用户名和密码的正确与否进行判断
                                        System.out.println("请输入用户的用户名(不少于5个字符)");
                                        try {
                                            userName_ = scanner.nextLine();
                                            if (userName_.length() >= 5) {
                                                isValueName_ = true;
                                            } else {
                                                throw new Exception("输入的用户名的长度要求不少于5个字符，请重新输入：");
                                            }
                                        } catch (Exception e) {
                                            System.out.print("输入的字符串长度要求不少于五个字符,请重新输入：");
                                        }
                                    }

                                    System.out.println("请输入用户的密码（密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合）");
                                    boolean isValuePassword_ = false;

                                    while (!isValuePassword_) {
                                        try {
                                            userPassword_ = scanner.nextLine();
                                            // 定义正则表达式
                                            String pattern_ = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
                                            // 创建 Pattern 对象
                                            Pattern p_ = Pattern.compile(pattern_);
                                            // 创建 Matcher 对象
                                            Matcher m_ = p_.matcher(userPassword_);
                                            if (m_.matches()) {
                                                isValuePassword_ = true;
                                            } else {
                                                throw new Exception("输入的密码要求密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合，请重新输入：");
                                            }
                                        } catch (Exception e) {
                                            System.out.print("输入的密码要求密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合，请重新输入：");
                                        }
                                    }
                                    user.userLogin(userName_, userPassword_);
                                    //当userLogin的返回值为true时，break，否则继续循环
                                    //break;
                                //}
                                //当i小于5的时候输出登录成功，否则登录失败
                                System.out.println("登录成功!!!");

                                break;
                            case 3:
                                //用户-密码管理功能
                                System.out.println("-----欢迎来到用户密码管理模块-----");
                                System.out.println("1.修改自身密码(密码长度大于 8 个字符，必须是大小写字母、数字和标点符号的组合)");
                                System.out.println("2.忘记密码");
                                System.out.println("3.退出登录");
                                System.out.print("请选择你要执行的功能：");
                                //用户密码管理可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                                boolean validInput1_3 = false;
                                int number1_3 = 0;
                                while (!validInput1_3) {
                                    try {
                                        number1_3 = Integer.parseInt(scanner.nextLine());
                                        if (number1_3 >= 1 && number1_3 <= 3) {
                                            validInput1_3 = true;
                                        } else {
                                            throw new Exception("你必须输入1，2，3这三个数字中的一个，请重新输入：");
                                        }
                                    } catch (Exception e) {
                                        System.out.print("你必须输入1，2，3这三个数字中的一个，请重新输入：");
                                    }
                                }
                                //用户密码管理已经选择要执行的功能(1,2，3)
                                switch (number1_3) {
                                    case 1:
                                        //用户-密码管理-修改自身密码
                                        String userPassword__ = null;
                                        System.out.println("请输入用户的新密码（密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合）");
                                        boolean isValuePassword__ = false;
                                        while (!isValuePassword__) {
                                            try {
                                                userPassword__ = scanner.nextLine();
                                                // 定义正则表达式
                                                String pattern_ = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
                                                // 创建 Pattern 对象
                                                Pattern p_ = Pattern.compile(pattern_);
                                                // 创建 Matcher 对象
                                                Matcher m_ = p_.matcher(userPassword__);
                                                if (m_.matches()) {
                                                    isValuePassword__ = true;
                                                } else {
                                                    throw new Exception("输入的密码要求密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合，请重新输入：");
                                                }
                                            } catch (Exception e) {
                                                System.out.print("输入的密码要求密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合，请重新输入：");
                                            }
                                        }
                                        user.userChangePassword(userPassword__);
                                        System.out.println("修改密码成功!!!");
                                        break;


                                    case 2:
                                        //用户-密码管理-忘记密码
                                        //先获取到用户的用户名以及邮箱，然后给用户邮箱发送一个随机密码（满足正确密码的条件）
                                        System.out.println("请输入您的用户名");
                                        String userGetName = scanner.nextLine();
                                        System.out.println("请输入您注册时所用的邮箱");
                                        String userGetEmail = scanner.nextLine();

                                        user.userForgetPassword(userGetName, userGetEmail);

                                        System.out.println("已成功将随机密码发送给您的邮箱！！！");
                                        break;

                                    case 3:
                                        //用户-密码管理-退出登录
                                        System.out.println("确定要退出用户登录吗？(Yes/No)");
                                        String YN = scanner.nextLine();
                                        if (YN.equals("Yes")) {
                                            isUser = true;
                                            break;
                                        }

                                }

                                break;
                            case 4:
                                //用户-购票管理功能
                                System.out.println("-----欢迎来到用户购物管理模块-----");
                                System.out.println("1.查看所有电影放映信息");
                                System.out.println("2.查看指定电影放映信息");
                                System.out.println("3.购票");
                                System.out.println("4.付账");
                                System.out.println("5.取票");
                                System.out.println("6.查看购物历史");
                                System.out.println("7.退出登录");
                                System.out.print("请选择你要执行的功能：");
                                //用户购物管理可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                                boolean validInput1_4 = false;
                                int number1_4 = 0;
                                while (!validInput1_4) {
                                    try {
                                        number1_4 = Integer.parseInt(scanner.nextLine());
                                        if (number1_4 >= 1 && number1_4 <= 7) {
                                            validInput1_4 = true;
                                        } else {
                                            throw new Exception("你必须输入1，2，3，4，5，6，7这七个数字中的一个，请重新输入：");
                                        }
                                    } catch (Exception e) {
                                        System.out.print("你必须输入1，2，3，4，5，6，7这七个数字中的一个，请重新输入：");
                                    }
                                }
                                //用户购物管理已经选择要执行的功能(1,2，3，4，5，6，7)
                                switch (number1_4) {
                                    case 1:
                                        //用户-购物管理-查看所有电影放映信息
                                        user.list();
                                        System.out.println("所有电影的放映信息如下：.....");
                                        break;

                                    case 2:
                                        //用户-购物管理-查看指定电影放映信息
                                        //先拿到用户所指定的电影名字
                                        System.out.print("请输入要查询的电影名称:");
                                        String movieName = scanner.nextLine();
                                        user.onMovie(movieName);
                                        System.out.println("指定电影的放映信息如下：.....");
                                        break;

                                    case 3:
                                        //用户-购物管理-购票
                                        //先选择场次，显示出座位信息，然后输入座位号，进行购票
                                        System.out.print("请输入场次，之后为您显示场次的座位情况");
                                        int changCi = scanner.nextInt();
                                        user.buyTicket(changCi);
                                        System.out.println("购票成功！！！");
                                        break;

                                    case 4:
                                        //用户-购物管理-付账
                                        //生成随机的电影票ID
                                        Random random = new Random();
                                        int cinemaID;
                                        cinemaID = random.nextInt(900000) + 100000;
                                        user.giveMoney(cinemaID);
                                        System.out.println("付款成功！！！");
                                        break;

                                    case 5:
                                        //用户-购物管理-取票
                                        user.getTicket();
                                        System.out.println("取票成功");
                                        break;

                                    case 6:
                                        //用户-购物管理-查看购物历史
                                        //在文件中找到该用户的的购物历史，并输出
                                        System.out.println("购物历史信息如下：.....");
                                        break;

                                    case 7:
                                        //用户-购物管理-退出登录
                                        System.out.println("确定要退出用户登录吗？(Yes/No)");
                                        String YN = scanner.nextLine();
                                        if (YN.equals("Yes")) {
                                            break;
                                        }
                                        break;
                                }

                                break;
                            case 5:
                                //用户-退出登录功能
                                //要有再次确认是否退出登录的提示，退出后，到达角色的选择的页面
                                System.out.println("确定要退出用户登录吗？(Yes/No)");
                                String YN = scanner.nextLine();
                                if (YN.equals("Yes")) {
                                    isUser = true;
                                    break;
                                }
                                break;
                        }

                    }
                    break;
                case 2:
                    //经理模块
                    boolean isManage = false;
                    while (!isManage) {
                        System.out.println("-----欢迎来到经理模块-----");
                        System.out.println("1.登录");
                        System.out.println("2.影片管理");
                        System.out.println("3.排片管理");
                        System.out.println("4.退出登录");
                        System.out.print("请选择你要执行的功能(输入对应功能前面的数字)：");
                        //用户模块的选择中可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                        boolean validInput2 = false;
                        int number2 = 0;
                        while (!validInput2) {
                            try {
                                number2 = Integer.parseInt(scanner.nextLine());
                                if (number2 >= 1 && number2 <= 4) {
                                    validInput2 = true;
                                } else {
                                    throw new Exception("你必须输入1，2，3，4这四个数字中的一个，请重新输入：");
                                }
                            } catch (Exception e) {
                                System.out.print("你必须输入1，2，3，4这四个数字中的一个，请重新输入：");
                            }
                        }
                        Manager manager = new Manager();
                        //经理选择了四个功能中的一个
                        switch (number2) {
                            case 1:
                                //经理-登录功能(账号为manage，密码为123456)
                                manager.managerLogin(manager.getAccount(), manager.getPassword());
                                System.out.print("登录成功！！！");
                                break;
                            case 2:
                                //经理-影片管理功能
                                System.out.println("-----欢迎来到经理影片管理模块-----");
                                System.out.println("1.列出所有正在上映影片的信息");
                                System.out.println("2.添加影片的信息");
                                System.out.println("3.修改电影的信息");
                                System.out.println("4.删除影片的信息");
                                System.out.println("5.查询影片的信息");
                                System.out.println("6.退出登录");
                                System.out.print("请选择你要执行的功能：");
                                //经理影片管理可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                                boolean validInput2_2 = false;
                                int number2_2 = 0;
                                while (!validInput2_2) {
                                    try {
                                        number2_2 = Integer.parseInt(scanner.nextLine());
                                        if (number2_2 >= 1 && number2_2 <= 5) {
                                            validInput2_2 = true;
                                        } else {
                                            throw new Exception("你必须输入1，2，3，4，5这五个数字中的一个，请重新输入：");
                                        }
                                    } catch (Exception e) {
                                        System.out.print("你必须输入1，2，3，4，5这五个数字中的一个，请重新输入：");
                                    }
                                }
                                //经理影片管理已经选择要执行的功能(1,2，3，4，5，6)
                                switch (number2_2) {
                                    case 1:
                                        //经理-影片管理-列出所有正在上映影片的信息
                                        manager.list();
                                        break;


                                    case 2:
                                        //经理-影片管理-添加影片的信息
                                        //先创建出一个新的影片，然后在影片文件中添加该影片
                                        System.out.print("请输入新影片的片名");
                                        String title = scanner.nextLine();
                                        System.out.print("请输入新影片的导演");
                                        String director = scanner.nextLine();
                                        System.out.print("请输入新影片的主演");
                                        String leadingActor = scanner.nextLine();
                                        System.out.print("请输入新影片的类型");
                                        String genre = scanner.nextLine();
                                        System.out.print("请输入新影片的剧情简介");
                                        String plot = scanner.nextLine();
                                        System.out.print("请输入新影片的时长");
                                        int duration = scanner.nextInt();
                                        Movie movie = new Movie(title, director, leadingActor, genre, plot, duration);
                                        manager.addMovie(movie);
                                        break;

                                    case 3:
                                        //经理-影片管理-修改电影的信息
                                        //找到影片文件中的某部影片进行修改
                                        //输入想要修改影片的名称
                                        System.out.print("请输入修改影片的名称:");
                                        String changeMovie = scanner.nextLine();
                                        manager.changeMovie(changeMovie);
                                        break;

                                    case 4:
                                        //经理-影片管理-删除影片的信息
                                        //输入想要删除影片的名称
                                        System.out.print("请输入想要删除影片的名称:");
                                        String DeleteMovie = scanner.nextLine();
                                        //根据DeleteMovie去影片文件中删除影片，并且注意：要给出警告提示
                                        System.out.print("你确定要删除该影片吗？(Yes/Nn)");
                                        String YN = scanner.nextLine();
                                        if (YN.equals("Yes")) {
                                            manager.deleteMovie(DeleteMovie);
                                        }
                                        break;

                                    case 5:
                                        //经理-影片管理-退出登录
                                        System.out.println("确定要退出经理登录吗？(Yes/No)");
                                        String YN2 = scanner.nextLine();
                                        if (YN2.equals("Yes")) {
                                            isManage = true;
                                            break;
                                        }
                                        break;

                                }
                                break;
                            case 3:
                                //经理-拍片管理功能
                                System.out.println("-----欢迎来到经理排片管理模块-----");
                                System.out.println("1.增加场次");
                                System.out.println("2.修改场次");
                                System.out.println("3.删除场次");
                                System.out.println("4.列出所有场次信息");
                                System.out.println("5.退出经理页面");
                                System.out.print("请选择你要执行的功能：");
                                //经理排片管理可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                                boolean validInput2_3 = false;
                                int number2_3 = 0;
                                while (!validInput2_3) {
                                    try {
                                        number2_3 = Integer.parseInt(scanner.nextLine());
                                        if (number2_3 >= 1 && number2_3 <= 5) {
                                            validInput2_3 = true;
                                        } else {
                                            throw new Exception("你必须输入1，2，3，4，5这五个数字中的一个，请重新输入：");
                                        }
                                    } catch (Exception e) {
                                        System.out.print("你必须输入1，2，3，4，5这五个数字中的一个，请重新输入：");
                                    }
                                }
                                //经理排片管理已经选择要执行的功能(1,2，3，4，5)
                                switch (number2_3) {
                                    case 1:
                                        //经理-排片管理-增加场次
                                        //先拿到经理想要增加场次的场次数字
                                        System.out.println("请输入场次的数字");
                                        int changCi = scanner.nextInt();
                                        manager.addChangCi(changCi);
                                        break;


                                    case 2:
                                        //经理-排片管理-修改场次
                                        //先拿到经理想要修改场次的场次数字
                                        System.out.println("请输入场次的数字");
                                        int changCi_ = scanner.nextInt();
                                        manager.changeChangCi(changCi_);
                                        break;

                                    case 3:
                                        //经理-排片管理-删除场次
                                        //先拿到经理想要删除场次的场次数字
                                        System.out.println("请输入场次的数字");
                                        int changCi__ = scanner.nextInt();
                                        manager.deleteChangCi(changCi__);

                                        break;

                                    case 4:
                                        //经理-排片管理-列出所有场次信息
                                        //遍历所有场次的场次数字，拿着场次数字到场次文中输出场次信息
                                        manager.listChangCi();
                                        System.out.println("所有场次的信息如下：....");
                                        break;

                                    case 5:
                                        //经理-排片管理-退出登录
                                        System.out.println("确定要退出经理登录吗？(Yes/No)");
                                        String YN2 = scanner.nextLine();
                                        if (YN2.equals("Yes")) {
                                            isManage = true;
                                            break;
                                        }
                                        break;

                                }

                                break;
                            case 4:
                                //经理-退出经理页面的功能，同时跳转到选择角色处
                                System.out.println("确定要退出经理登录吗？(Yes/No)");
                                String YN2 = scanner.nextLine();
                                if (YN2.equals("Yes")) {
                                    isManage = true;
                                    break;
                                }
                                break;
                        }
                    }
                    break;

                case 3:
                    //管理员模块
                    boolean isAdmin = false;
                    while (!isAdmin) {
                        System.out.println("-----欢迎来到管理员模块-----");
                        System.out.println("1.登录");
                        System.out.println("2.密码管理");
                        System.out.println("3.用户管理");
                        System.out.println("4.退出管理员页面");
                        System.out.print("请选择你要执行的功能(输入对应功能前面的数字)：");
                        //管理员模块的选择中可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                        boolean validInput3 = false;
                        int number3 = 0;
                        while (!validInput3) {
                            try {
                                number3 = Integer.parseInt(scanner.nextLine());
                                if (number3 >= 1 && number3 <= 4) {
                                    validInput3 = true;
                                } else {
                                    throw new Exception("你必须输入1，2，3，4这四个数字中的一个，请重新输入：");
                                }
                            } catch (Exception e) {
                                System.out.print("你必须输入1，2，3，4这四个数字中的一个，请重新输入：");
                            }
                        }

                        //管理员选择了四个功能中的一个
                        Admin admin = new Admin();
                        switch (number3) {
                            case 1:
                                //管理员-登录功能
                                System.out.println("请输入管理员的账号(初始账号为admin)");
                                String account = scanner.nextLine();
                                System.out.println("请输入管理员的密码（初始密码为ynuadmin）");
                                String passWord = scanner.nextLine();
                                admin.adminLogin(account, passWord);
                                System.out.print("登录成功！！！");
                                break;
                            case 2:
                                //管理员-密码管理功能
                                System.out.println("-----欢迎来到管理员密码管理模块-----");
                                System.out.println("1.修改自己管理员的密码");
                                System.out.println("2.根据用户账户去重置用户的密码");
                                System.out.println("3.退出登录");
                                System.out.print("请选择你要执行的功能：");
                                //管理员密码管理功能中可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                                boolean validInput3_2 = false;
                                int number3_2 = 0;
                                while (!validInput3_2) {
                                    try {
                                        number3_2 = Integer.parseInt(scanner.nextLine());
                                        if (number3_2 >= 1 && number3_2 <= 3) {
                                            validInput3_2 = true;
                                        } else {
                                            throw new Exception("你必须输入1，2，3这三个数字中的一个，请重新输入：");
                                        }
                                    } catch (Exception e) {
                                        System.out.print("你必须输入1，2，3这三个数字中的一个，请重新输入：");
                                    }
                                }
                                //管理员密码管理已经选择要执行的功能(1,2，3)
                                switch (number3_2) {
                                    case 1:
                                        //管理员-密码管理-修改自己管理员的密码
                                        //新密码
                                        System.out.print("请输入管理员的新密码：");
                                        String changePassword = scanner.next();
                                        admin.changePassword(changePassword);
                                        System.out.print("修改密码成功！！！");
                                        break;


                                    case 2:
                                        //管理员-密码管理-根据用户账号去重置用户的密码
                                        //不能查看到用户的密码
                                        System.out.println("请输入用户的账号：");
                                        String userAccount = scanner.nextLine();

                                        admin.resetUserPassword(userAccount);

                                        break;

                                    case 3:
                                        //管理员-密码管理-退出登录
                                        System.out.println("确定要退出管理员登录吗？(Yes/No)");
                                        String YN2 = scanner.nextLine();
                                        if (YN2.equals("Yes")) {
                                            isAdmin = true;
                                            break;
                                        }
                                        break;
                                }
                                break;
                            case 3:
                                //管理员-用户管理功能
                                System.out.println("-----欢迎来到管理员用户管理模块-----");
                                System.out.println("1.列出所有用户信息");
                                System.out.println("2.删除用户信息");
                                System.out.println("3.根据用户ID或者用户名来查询");
                                System.out.println("4.退出登录");
                                System.out.print("请选择你要执行的功能：");
                                //经理影片管理可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                                boolean validInput3_3 = false;
                                int number3_3 = 0;
                                while (!validInput3_3) {
                                    try {
                                        number3_3 = Integer.parseInt(scanner.nextLine());
                                        if (number3_3 >= 1 && number3_3 <= 4) {
                                            validInput3_3 = true;
                                        } else {
                                            throw new Exception("你必须输入1，2，3，4这四个数字中的一个，请重新输入：");
                                        }
                                    } catch (Exception e) {
                                        System.out.print("你必须输入1，2，3，4这四个数字中的一个，请重新输入：");
                                    }
                                }
                                //管理员用户管理已经选择要执行的功能(1,2，3，4)
                                switch (number3_3) {
                                    case 1:
                                        //管理员-用户管理-列出所有用户信息
                                        admin.list();
                                        break;


                                    case 2:
                                        //管理员-用户管理-删除用户信息
                                        //在删除前要给出警告提示
                                        //根据用户名在文件中找到该用户,进而删除用户信息
                                        System.out.println("你确定要删除用户吗？（Yes/No）");
                                        String YN = scanner.nextLine();
                                        if (YN.equals("Yes")) {
                                            System.out.println("请输入想要删除的用户名:");
                                            String userName = scanner.nextLine();
                                            admin.deleteUserInformation(userName);
                                            System.out.println("删除成功！！!");
                                        }

                                        break;

                                    case 3:
                                        //管理员-用户管理-根据用户ID或者用户名进行查询
                                        System.out.println("请输入想要查询的用户名:");
                                        String userName = scanner.nextLine();
                                        admin.findUserInformation(userName);

                                        break;
                                }
                                break;

                            case 4:
                                //管理员-用户管理-退出管理员页面
                                System.out.println("确定要退出管理员登录吗？(Yes/No)");
                                String YN2 = scanner.nextLine();
                                if (YN2.equals("Yes")) {
                                    isAdmin = true;
                                    break;
                                }
                                break;

                        }
                    }
                    break;
                case 4:
                    //前台模块
                    boolean isReceptionist = false;
                    while (!isReceptionist) {
                        System.out.println("-----欢迎来到前台模块-----");
                        System.out.println("1.登录");
                        System.out.println("2.列出所有正在上映影片的信息");
                        System.out.println("3.列出所有正在上映影片的信息");
                        System.out.println("4.列出指定电影和场次的信息");
                        System.out.println("5.售票功能");
                        System.out.println("6.退出前台页面");
                        System.out.print("请选择你要执行的功能(输入对应功能前面的数字)：");
                        //前台模块的选择中可以一直输入一个数字，对于用户输入的内容可以进行try-catch捕捉，并且做出提示语句。
                        boolean validInput4 = false;
                        int number4 = 0;
                        while (!validInput4) {
                            try {
                                number4 = Integer.parseInt(scanner.nextLine());
                                if (number4 >= 1 && number4 <= 6) {
                                    validInput4 = true;
                                } else {
                                    throw new Exception("你必须输入1，2，3，4，5，6这六个数字中的一个，请重新输入：");
                                }
                            } catch (Exception e) {
                                System.out.print("你必须输入1，2，3，4，5，6这六个数字中的一个，请重新输入：");
                            }
                        }

                        //前台选择了六个功能中的一个
                        Receptionist receptionist = new Receptionist();
                        switch (number4) {
                            case 1:
                                //前台-登录功能
                                receptionist.receptionistLogin(receptionist.getAccount(), receptionist.getPassword());
                                break;
                            case 2:
                                //前台-列出所有上映影片的信息功能
                                receptionist.allOnlist();
                                break;
                            case 3:
                                //前台-列出所有正在上映影片的信息
                                receptionist.onlist();
                                break;
                            case 4:
                                //前台-列出指定电影和场次的信息
                                //输入指定电影
                                System.out.print("请输入指定电影的名称，将会列出场次座位信息");
                                String movie = scanner.nextLine();
                                receptionist.movieAndChangci(movie);

                                break;

                            case 5:
                                //前台-售票功能
                                //根据片名，场次，用户名/手机号，支付金额，来输出电影票的信息（包括ID）
                                System.out.print("请输入电影的片名");
                                String title = scanner.nextLine();
                                System.out.print("请输入电影的场次");
                                String changCi = scanner.nextLine();
                                System.out.print("请输入电影的用户名/手机号");
                                String user = scanner.nextLine();
                                System.out.print("请输入电影的支付金额");
                                String price = scanner.nextLine();
                                receptionist.sellTicket(title, changCi, user, price);
                                System.out.println("售票成功！！！");
                                break;

                            case 6:
                                //前台-退出登录
                                System.out.println("确定要退出前台登录吗？(Yes/No)");
                                String YN2 = scanner.nextLine();
                                if (YN2.equals("Yes")) {
                                    isReceptionist = true;
                                    break;
                                }
                                break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("已成功退出影院管理系统");
                    exit(0);
                    break;

            }
        }
    }
}


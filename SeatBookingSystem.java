import java.util.Scanner;

public class SeatBookingSystem {

    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static final int LOCK_DURATION = 2; // 锁定座位的时间（单位：分钟）

    private static final String EMPTY = "O";
    private static final String OCCUPIED = "X";

    private static String[][] seats = new String[ROWS][COLS];
    private static boolean[][] seatLocks = new boolean[ROWS][COLS];
    private static long[][] lockTimes = new long[ROWS][COLS];

    public static void SeatBooking() {
        initializeSeats();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printSeats();
            System.out.print("请输入座位号（示例：A1）：");
            String seatNumber = scanner.nextLine();

            if (isValidSeatNumber(seatNumber)) {
                int row = seatNumber.charAt(0) - 'A';
                int col = Integer.parseInt(seatNumber.substring(1)) - 1;

                if (isSeatAvailable(row, col)) {
                    lockSeat(row, col);
                    System.out.println("已锁定座位，有效时间为" + LOCK_DURATION + "分钟。");

                    // 等待2分钟
                    try {
                        Thread.sleep(LOCK_DURATION * 60 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (isSeatLocked(row, col)) {
                        System.out.print("是否支付（Y/N）：");
                        String choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            bookSeat(row, col);
                            System.out.println("购票成功！");
                        } else {
                            unlockSeat(row, col);
                            System.out.println("购票超时，座位已释放。");
                        }
                    } else {
                        System.out.println("购票超时，座位已释放。");
                    }
                } else {
                    System.out.println("座位已被占用，请选择其他座位。");
                }
            } else {
                System.out.println("无效的座位号，请重新输入。");
            }
        }
    }

    private static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seats[i][j] = EMPTY;
                seatLocks[i][j] = false;
                lockTimes[i][j] = 0;
            }
        }
    }

    private static void printSeats() {
        System.out.println("座位信息：");
        System.out.print("  ");
        for (int i = 1; i <= COLS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < ROWS; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidSeatNumber(String seatNumber) {
        if (seatNumber.length() != 2) {
            return false;
        }

        char rowChar = seatNumber.charAt(0);
        int col = Integer.parseInt(seatNumber.substring(1));

        return rowChar >= 'A' && rowChar < 'A' + ROWS && col >= 1 && col <= COLS;
    }

    private static boolean isSeatAvailable(int row, int col) {
        return seats[row][col].equals(EMPTY) && !seatLocks[row][col];
    }

    private static boolean isSeatLocked(int row, int col) {
        return seatLocks[row][col];
    }

    private static void lockSeat(int row, int col) {
        seatLocks[row][col] = true;
        lockTimes[row][col] = System.currentTimeMillis();
    }

    private static void unlockSeat(int row, int col) {
        seatLocks[row][col] = false;
        lockTimes[row][col] = 0;
    }

    private static void bookSeat(int row, int col) {
        seats[row][col] = OCCUPIED;
        unlockSeat(row, col);
    }
}

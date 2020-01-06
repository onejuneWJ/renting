package cn.edu.tf.constant;

/**
 * @author : 王俊
 * @date : 2019/9/29 9:42
 **/
public class Constant {
    public static String SUCCESS = "success";
    public static String FAILED="failed";

    public interface status{
        String IN_RENT="IN_RENT";
    }

    public enum Rentals {
        /**
         * 租金范围
         */
        QZ1("500元以下", 0, null, 500D),
        QZ2("500-800元", 1, 500D, 800D),
        QZ3("800-1000元", 2, 800d, 100d),
        QZ4("1000-1500元", 3, 1000D, 1500D),
        QZ5("1500-2000元", 4, 1500D, 2000D),
        QZ6("2000-3000元", 5, 2000D, 3000D),
        QZ7("3000-5000元", 6, 3000D, 5000D),
        QZ8("5000-8000元", 7, 5000D, 8000D),
        QZ9("8000元以上", 8, 8000D, null);

        private String name;
        private int index;
        private Double queryStart;
        private Double queryEnd;

        Rentals(String name, int index, Double queryStart, Double queryEnd) {
            this.name = name;
            this.index = index;
            this.queryStart = queryStart;
            this.queryEnd = queryEnd;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Double getQueryStart() {
            return queryStart;
        }

        public void setQueryStart(Double queryStart) {
            this.queryStart = queryStart;
        }

        public Double getQueryEnd() {
            return queryEnd;
        }

        public void setQueryEnd(Double queryEnd) {
            this.queryEnd = queryEnd;
        }
    }

    public enum HouseType {
        /**
         * 房型枚举常量
         */
        FX1("一室", 0, 1),
        FX2("二室", 1, 2),
        FX3("三室", 2, 3),
        FX4("四室", 3, 4),
        FX5("五室及以上", 4, 5);

        private String name;
        private int index;
        private Integer num;

        HouseType(String name, int index, Integer num) {
            this.name = name;
            this.index = index;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }


}

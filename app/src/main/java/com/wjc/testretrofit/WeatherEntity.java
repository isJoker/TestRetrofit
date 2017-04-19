package com.wjc.testretrofit;

import java.util.List;

/**
 * Created by ${万嘉诚} on 2016/11/28.
 * WeChat：wjc398556712
 * Function：
 */

public class WeatherEntity {

    /**
     * desc : OK
     * status : 1000
     * data : {"wendu":"2","ganmao":"将有一次强降温过程，天气寒冷，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。","forecast":[{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 8℃","type":"晴","low":"低温 -3℃","date":"28日星期一"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 3℃","type":"雨夹雪","low":"低温 -4℃","date":"29日星期二"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 8℃","type":"霾","low":"低温 -1℃","date":"30日星期三"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 7℃","type":"晴","low":"低温 -4℃","date":"1日星期四"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 9℃","type":"晴","low":"低温 -3℃","date":"2日星期五"}],"yesterday":{"fl":"3-4级","fx":"北风","high":"高温 8℃","type":"晴","low":"低温 -4℃","date":"27日星期日"},"aqi":"125","city":"北京"}
     */

    private String desc;
    private int status;
    /**
     * wendu : 2
     * ganmao : 将有一次强降温过程，天气寒冷，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。
     * forecast : [{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 8℃","type":"晴","low":"低温 -3℃","date":"28日星期一"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 3℃","type":"雨夹雪","low":"低温 -4℃","date":"29日星期二"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 8℃","type":"霾","low":"低温 -1℃","date":"30日星期三"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 7℃","type":"晴","low":"低温 -4℃","date":"1日星期四"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 9℃","type":"晴","low":"低温 -3℃","date":"2日星期五"}]
     * yesterday : {"fl":"3-4级","fx":"北风","high":"高温 8℃","type":"晴","low":"低温 -4℃","date":"27日星期日"}
     * aqi : 125
     * city : 北京
     */

    private DataBean data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String wendu;
        private String ganmao;
        /**
         * fl : 3-4级
         * fx : 北风
         * high : 高温 8℃
         * type : 晴
         * low : 低温 -4℃
         * date : 27日星期日
         */

        private YesterdayBean yesterday;
        private String aqi;
        private String city;
        /**
         * fengxiang : 无持续风向
         * fengli : 微风级
         * high : 高温 8℃
         * type : 晴
         * low : 低温 -3℃
         * date : 28日星期一
         */

        private List<ForecastBean> forecast;

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            private String fl;
            private String fx;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

        public static class ForecastBean {
            private String fengxiang;
            private String fengli;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}

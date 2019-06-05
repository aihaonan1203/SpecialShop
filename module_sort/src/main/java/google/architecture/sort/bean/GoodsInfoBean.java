package google.architecture.sort.bean;

import java.util.List;

/**
 * Created by Hjb on 2019/6/5.
 */

public class GoodsInfoBean {

    /**
     * code : 200
     * data : {"hcapi":{"category_id":"16","coupon_click_url":"https://uland.taobao.com/coupon/edetail?e=5AodUwTUms0GQASttHIRqYezysEZpJsbWdXuxkjql3Yutf0gQ4DERg7eIrXgq70oiyATCvRoNjascqbsOpdGLqpASYC9W7lPCi%2BP3nw3s2o54A3GBeyId%2FsnwWZGSCD41ug731VBEQm0m3Ckm6GN2CwynAdGnOngkM20EQQvoa6RJbAtAAE4z9h24p%2B5DSSY&traceId=0bb7f51e15597039776431521e&union_lens=lensId:0b01c1f1_0bad_16b2599fed0_c613&xId=D7CQwHFELqjiSJ7QB6YoylHFTlDI7FuSZcyZFsUgNKNG8ZqDXU6tIHCBaqN5Q6wVGBhLLhZehwz2dnu6eWp3Pl","coupon_end_time":"2019-06-08","coupon_info":"满65元减30元","coupon_remain_count":"99977","coupon_start_time":"2019-06-05","coupon_total_count":"100000","coupon_type":"3","commission_rate":"9.00","num_iid":"590402597799","tbk_pwd":"￥Pug3YejlCOP￥","coupon_short_url":"https://s.click.taobao.com/mXclZ8w"},"imgs":{"item_detail":["https://img.alicdn.com/imgextra/i2/2983402510/O1CN018S202t1UPcdTjzhwq_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN019q7LU31UPcdXBz76v_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN019Y30qC1UPcdXlvmYM_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN014ko8CP1UPcdW7cyM6_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01oJyHZ81UPcdTOGSH4_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01qEBtWS1UPcdUXym7E_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN019DpIsu1UPcdXTDlOL_!!2983402510.jpg","https://img.alicdn.com/imgextra/i3/2983402510/O1CN01xTfQs91UPcdVzlVWT_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01uwZqy51UPcdXTCxVm_!!2983402510.jpg","https://img.alicdn.com/imgextra/i3/2983402510/O1CN01kYjC1B1UPcdV88niT_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01CpArv71UPcdTk2jFM_!!2983402510.jpg","https://img.alicdn.com/imgextra/i3/2983402510/O1CN01Z0DPYJ1UPcdXBwtfT_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01EwKpWL1UPcdVznWFM_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01sJhOwW1UPcdUXvksA_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01jXT8lR1UPcdO75f2m_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01HEiEXf1UPcdXTDtkm_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01fgkMBD1UPcdUXxy3F_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01pMZfIQ1UPcdV852jT_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN016tM8vs1UPcdVBxWTi_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01dLebZD1UPcdUoHDip_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN0155eHbv1UPcdW2Hs8p_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01e9yOdv1UPcdW7eeWz_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01JyibB71UPcdXluVQA_!!2983402510.jpg","https://img.alicdn.com/imgextra/i3/2983402510/O1CN01Dlbtw91UPcdV86zSc_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01y080ES1UPcdVznO7n_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01iJIjbL1UPcdTk0NbM_!!2983402510.jpg"],"video":[{"model":{"componentTitle":{"text":"宝贝视频"},"thumbnail":"//img.alicdn.com/sns_album/TB1Znosav1G3KVjSZFkwu1K4XXa.png","videoId":"227367949276","videoUrl":"https://cloud.video.taobao.com/play/u/2983402510/p/2/e/6/t/1/227367949276.mp4?appKey=7596","title":"时尚街拍","subTitle":"夏季新款雪纺免搭阔腿裤套装","spm":"a2141.7631564.1999020245"},"styles":{"size":{"height":"348","width":"620"},"backgroundColor":"#ffffff","lineColor":"#ff5000","titleColor":"#051b28"}}]}}
     * msg : 返回数据成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * hcapi : {"category_id":"16","coupon_click_url":"https://uland.taobao.com/coupon/edetail?e=5AodUwTUms0GQASttHIRqYezysEZpJsbWdXuxkjql3Yutf0gQ4DERg7eIrXgq70oiyATCvRoNjascqbsOpdGLqpASYC9W7lPCi%2BP3nw3s2o54A3GBeyId%2FsnwWZGSCD41ug731VBEQm0m3Ckm6GN2CwynAdGnOngkM20EQQvoa6RJbAtAAE4z9h24p%2B5DSSY&traceId=0bb7f51e15597039776431521e&union_lens=lensId:0b01c1f1_0bad_16b2599fed0_c613&xId=D7CQwHFELqjiSJ7QB6YoylHFTlDI7FuSZcyZFsUgNKNG8ZqDXU6tIHCBaqN5Q6wVGBhLLhZehwz2dnu6eWp3Pl","coupon_end_time":"2019-06-08","coupon_info":"满65元减30元","coupon_remain_count":"99977","coupon_start_time":"2019-06-05","coupon_total_count":"100000","coupon_type":"3","commission_rate":"9.00","num_iid":"590402597799","tbk_pwd":"￥Pug3YejlCOP￥","coupon_short_url":"https://s.click.taobao.com/mXclZ8w"}
         * imgs : {"item_detail":["https://img.alicdn.com/imgextra/i2/2983402510/O1CN018S202t1UPcdTjzhwq_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN019q7LU31UPcdXBz76v_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN019Y30qC1UPcdXlvmYM_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN014ko8CP1UPcdW7cyM6_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01oJyHZ81UPcdTOGSH4_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01qEBtWS1UPcdUXym7E_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN019DpIsu1UPcdXTDlOL_!!2983402510.jpg","https://img.alicdn.com/imgextra/i3/2983402510/O1CN01xTfQs91UPcdVzlVWT_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01uwZqy51UPcdXTCxVm_!!2983402510.jpg","https://img.alicdn.com/imgextra/i3/2983402510/O1CN01kYjC1B1UPcdV88niT_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01CpArv71UPcdTk2jFM_!!2983402510.jpg","https://img.alicdn.com/imgextra/i3/2983402510/O1CN01Z0DPYJ1UPcdXBwtfT_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01EwKpWL1UPcdVznWFM_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01sJhOwW1UPcdUXvksA_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01jXT8lR1UPcdO75f2m_!!2983402510.jpg","https://img.alicdn.com/imgextra/i4/2983402510/O1CN01HEiEXf1UPcdXTDtkm_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01fgkMBD1UPcdUXxy3F_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01pMZfIQ1UPcdV852jT_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN016tM8vs1UPcdVBxWTi_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01dLebZD1UPcdUoHDip_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN0155eHbv1UPcdW2Hs8p_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01e9yOdv1UPcdW7eeWz_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01JyibB71UPcdXluVQA_!!2983402510.jpg","https://img.alicdn.com/imgextra/i3/2983402510/O1CN01Dlbtw91UPcdV86zSc_!!2983402510.jpg","https://img.alicdn.com/imgextra/i1/2983402510/O1CN01y080ES1UPcdVznO7n_!!2983402510.jpg","https://img.alicdn.com/imgextra/i2/2983402510/O1CN01iJIjbL1UPcdTk0NbM_!!2983402510.jpg"],"video":[{"model":{"componentTitle":{"text":"宝贝视频"},"thumbnail":"//img.alicdn.com/sns_album/TB1Znosav1G3KVjSZFkwu1K4XXa.png","videoId":"227367949276","videoUrl":"https://cloud.video.taobao.com/play/u/2983402510/p/2/e/6/t/1/227367949276.mp4?appKey=7596","title":"时尚街拍","subTitle":"夏季新款雪纺免搭阔腿裤套装","spm":"a2141.7631564.1999020245"},"styles":{"size":{"height":"348","width":"620"},"backgroundColor":"#ffffff","lineColor":"#ff5000","titleColor":"#051b28"}}]}
         */

        private HcapiBean hcapi;
        private ImgsBean imgs;

        public HcapiBean getHcapi() {
            return hcapi;
        }

        public void setHcapi(HcapiBean hcapi) {
            this.hcapi = hcapi;
        }

        public ImgsBean getImgs() {
            return imgs;
        }

        public void setImgs(ImgsBean imgs) {
            this.imgs = imgs;
        }

        public static class HcapiBean {
            /**
             * category_id : 16
             * coupon_click_url : https://uland.taobao.com/coupon/edetail?e=5AodUwTUms0GQASttHIRqYezysEZpJsbWdXuxkjql3Yutf0gQ4DERg7eIrXgq70oiyATCvRoNjascqbsOpdGLqpASYC9W7lPCi%2BP3nw3s2o54A3GBeyId%2FsnwWZGSCD41ug731VBEQm0m3Ckm6GN2CwynAdGnOngkM20EQQvoa6RJbAtAAE4z9h24p%2B5DSSY&traceId=0bb7f51e15597039776431521e&union_lens=lensId:0b01c1f1_0bad_16b2599fed0_c613&xId=D7CQwHFELqjiSJ7QB6YoylHFTlDI7FuSZcyZFsUgNKNG8ZqDXU6tIHCBaqN5Q6wVGBhLLhZehwz2dnu6eWp3Pl
             * coupon_end_time : 2019-06-08
             * coupon_info : 满65元减30元
             * coupon_remain_count : 99977
             * coupon_start_time : 2019-06-05
             * coupon_total_count : 100000
             * coupon_type : 3
             * commission_rate : 9.00
             * num_iid : 590402597799
             * tbk_pwd : ￥Pug3YejlCOP￥
             * coupon_short_url : https://s.click.taobao.com/mXclZ8w
             */

            private String category_id;
            private String coupon_click_url;
            private String coupon_end_time;
            private String coupon_info;
            private String coupon_remain_count;
            private String coupon_start_time;
            private String coupon_total_count;
            private String coupon_type;
            private String commission_rate;
            private String num_iid;
            private String tbk_pwd;
            private String coupon_short_url;

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCoupon_click_url() {
                return coupon_click_url;
            }

            public void setCoupon_click_url(String coupon_click_url) {
                this.coupon_click_url = coupon_click_url;
            }

            public String getCoupon_end_time() {
                return coupon_end_time;
            }

            public void setCoupon_end_time(String coupon_end_time) {
                this.coupon_end_time = coupon_end_time;
            }

            public String getCoupon_info() {
                return coupon_info;
            }

            public void setCoupon_info(String coupon_info) {
                this.coupon_info = coupon_info;
            }

            public String getCoupon_remain_count() {
                return coupon_remain_count;
            }

            public void setCoupon_remain_count(String coupon_remain_count) {
                this.coupon_remain_count = coupon_remain_count;
            }

            public String getCoupon_start_time() {
                return coupon_start_time;
            }

            public void setCoupon_start_time(String coupon_start_time) {
                this.coupon_start_time = coupon_start_time;
            }

            public String getCoupon_total_count() {
                return coupon_total_count;
            }

            public void setCoupon_total_count(String coupon_total_count) {
                this.coupon_total_count = coupon_total_count;
            }

            public String getCoupon_type() {
                return coupon_type;
            }

            public void setCoupon_type(String coupon_type) {
                this.coupon_type = coupon_type;
            }

            public String getCommission_rate() {
                return commission_rate;
            }

            public void setCommission_rate(String commission_rate) {
                this.commission_rate = commission_rate;
            }

            public String getNum_iid() {
                return num_iid;
            }

            public void setNum_iid(String num_iid) {
                this.num_iid = num_iid;
            }

            public String getTbk_pwd() {
                return tbk_pwd;
            }

            public void setTbk_pwd(String tbk_pwd) {
                this.tbk_pwd = tbk_pwd;
            }

            public String getCoupon_short_url() {
                return coupon_short_url;
            }

            public void setCoupon_short_url(String coupon_short_url) {
                this.coupon_short_url = coupon_short_url;
            }
        }

        public static class ImgsBean {
            private List<String> item_detail;
            private List<VideoBean> video;

            public List<String> getItem_detail() {
                return item_detail;
            }

            public void setItem_detail(List<String> item_detail) {
                this.item_detail = item_detail;
            }

            public List<VideoBean> getVideo() {
                return video;
            }

            public void setVideo(List<VideoBean> video) {
                this.video = video;
            }

            public static class VideoBean {
                /**
                 * model : {"componentTitle":{"text":"宝贝视频"},"thumbnail":"//img.alicdn.com/sns_album/TB1Znosav1G3KVjSZFkwu1K4XXa.png","videoId":"227367949276","videoUrl":"https://cloud.video.taobao.com/play/u/2983402510/p/2/e/6/t/1/227367949276.mp4?appKey=7596","title":"时尚街拍","subTitle":"夏季新款雪纺免搭阔腿裤套装","spm":"a2141.7631564.1999020245"}
                 * styles : {"size":{"height":"348","width":"620"},"backgroundColor":"#ffffff","lineColor":"#ff5000","titleColor":"#051b28"}
                 */

                private ModelBean model;
                private StylesBean styles;

                public ModelBean getModel() {
                    return model;
                }

                public void setModel(ModelBean model) {
                    this.model = model;
                }

                public StylesBean getStyles() {
                    return styles;
                }

                public void setStyles(StylesBean styles) {
                    this.styles = styles;
                }

                public static class ModelBean {
                    /**
                     * componentTitle : {"text":"宝贝视频"}
                     * thumbnail : //img.alicdn.com/sns_album/TB1Znosav1G3KVjSZFkwu1K4XXa.png
                     * videoId : 227367949276
                     * videoUrl : https://cloud.video.taobao.com/play/u/2983402510/p/2/e/6/t/1/227367949276.mp4?appKey=7596
                     * title : 时尚街拍
                     * subTitle : 夏季新款雪纺免搭阔腿裤套装
                     * spm : a2141.7631564.1999020245
                     */

                    private ComponentTitleBean componentTitle;
                    private String thumbnail;
                    private String videoId;
                    private String videoUrl;
                    private String title;
                    private String subTitle;
                    private String spm;

                    public ComponentTitleBean getComponentTitle() {
                        return componentTitle;
                    }

                    public void setComponentTitle(ComponentTitleBean componentTitle) {
                        this.componentTitle = componentTitle;
                    }

                    public String getThumbnail() {
                        return thumbnail;
                    }

                    public void setThumbnail(String thumbnail) {
                        this.thumbnail = thumbnail;
                    }

                    public String getVideoId() {
                        return videoId;
                    }

                    public void setVideoId(String videoId) {
                        this.videoId = videoId;
                    }

                    public String getVideoUrl() {
                        return videoUrl;
                    }

                    public void setVideoUrl(String videoUrl) {
                        this.videoUrl = videoUrl;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getSubTitle() {
                        return subTitle;
                    }

                    public void setSubTitle(String subTitle) {
                        this.subTitle = subTitle;
                    }

                    public String getSpm() {
                        return spm;
                    }

                    public void setSpm(String spm) {
                        this.spm = spm;
                    }

                    public static class ComponentTitleBean {
                        /**
                         * text : 宝贝视频
                         */

                        private String text;

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }
                    }
                }

                public static class StylesBean {
                    /**
                     * size : {"height":"348","width":"620"}
                     * backgroundColor : #ffffff
                     * lineColor : #ff5000
                     * titleColor : #051b28
                     */

                    private SizeBean size;
                    private String backgroundColor;
                    private String lineColor;
                    private String titleColor;

                    public SizeBean getSize() {
                        return size;
                    }

                    public void setSize(SizeBean size) {
                        this.size = size;
                    }

                    public String getBackgroundColor() {
                        return backgroundColor;
                    }

                    public void setBackgroundColor(String backgroundColor) {
                        this.backgroundColor = backgroundColor;
                    }

                    public String getLineColor() {
                        return lineColor;
                    }

                    public void setLineColor(String lineColor) {
                        this.lineColor = lineColor;
                    }

                    public String getTitleColor() {
                        return titleColor;
                    }

                    public void setTitleColor(String titleColor) {
                        this.titleColor = titleColor;
                    }

                    public static class SizeBean {
                        /**
                         * height : 348
                         * width : 620
                         */

                        private String height;
                        private String width;

                        public String getHeight() {
                            return height;
                        }

                        public void setHeight(String height) {
                            this.height = height;
                        }

                        public String getWidth() {
                            return width;
                        }

                        public void setWidth(String width) {
                            this.width = width;
                        }
                    }
                }
            }
        }
    }
}

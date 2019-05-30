package google.architecture.sort.bean;

import java.util.List;

/**
 * Created by Hjb on 2019/5/30.
 */

public class AllSortBean {


    /**
     * id : 1
     * cat_name : 女装
     * cat_icon : https://img.alicdn.com/imgextra/i1/2053469401/TB2oX82HL9TBuNjy0FcXXbeiFXa-2053469401.png
     * category_id : 16
     * parent_cid : 0
     * create_time : null
     * update_time : null
     * cate : [{"id":"2","cat_name":"外套","cat_icon":"https://img.alicdn.com/imgextra/i4/2053469401/O1CN012JJhsoAOrYNlKbb-2053469401.jpg","category_id":"50010548","parent_cid":"16","create_time":null,"update_time":null},{"id":"3","cat_name":"T恤","cat_icon":"https://img.alicdn.com/imgextra/i4/2053469401/O1CN01FI5Y912JJhtRlF1PP-2053469401.png","category_id":"50000436","parent_cid":"16","create_time":null,"update_time":null},{"id":"4","cat_name":"连衣裙","cat_icon":"https://img.alicdn.com/imgextra/i4/2053469401/O1CN01Tevn7I2JJhtfK39LK-2053469401.png","category_id":"50010850","parent_cid":"16","create_time":null,"update_time":null},{"id":"5","cat_name":"卫衣","cat_icon":"https://img.alicdn.com/imgextra/i2/2053469401/O1CN012JJhsmFofvZn9Qi-2053469401.jpg","category_id":"50008898","parent_cid":"16","create_time":null,"update_time":null},{"id":"6","cat_name":"套装","cat_icon":"https://img.alicdn.com/imgextra/i3/2053469401/TB2wcqxtDlYBeNjSszcXXbwhFXa-2053469401.png","category_id":"1624","parent_cid":"16","create_time":null,"update_time":null},{"id":"7","cat_name":"针织衫","cat_icon":"https://img.alicdn.com/imgextra/i2/2053469401/TB2WEMvk5OYBuNjSsD4XXbSkFXa-2053469401.png","category_id":"50000557","parent_cid":"16","create_time":null,"update_time":null},{"id":"8","cat_name":"衬衫","cat_icon":"https://img.alicdn.com/imgextra/i2/2053469401/TB2yeXntpuWBuNjSszbXXcS7FXa-2053469401.png","category_id":"162104","parent_cid":"16","create_time":null,"update_time":null},{"id":"9","cat_name":"开衫","cat_icon":"https://img.alicdn.com/imgextra/i4/2053469401/O1CN01hdBFzj2JJhur71LSv-2053469401.png","category_id":"50000697","parent_cid":"16","create_time":null,"update_time":null},{"id":"10","cat_name":"短外套","cat_icon":"https://img.alicdn.com/imgextra/i1/2053469401/O1CN01Kf85St2JJhutCPY0J-2053469401.png","category_id":"50011277","parent_cid":"16","create_time":null,"update_time":null},{"id":"11","cat_name":"休闲裤","cat_icon":"https://img.alicdn.com/imgextra/i2/2053469401/TB2xitHgTqWBKNjSZFxXXcpLpXa-2053469401.png","category_id":"3035","parent_cid":"16","create_time":null,"update_time":null},{"id":"12","cat_name":"雪纺衫","cat_icon":"https://img.alicdn.com/imgextra/i2/2053469401/TB2CcCCvMmTBuNjy1XbXXaMrVXa-2053469401.png","category_id":"162116","parent_cid":"16","create_time":null,"update_time":null},{"id":"13","cat_name":"长外套","cat_icon":"https://img.alicdn.com/imgextra/i4/2053469401/O1CN01qFwB662JJhutoLjt8-2053469401.png","category_id":"50008901","parent_cid":"16","create_time":null,"update_time":null},{"id":"14","cat_name":"中老年女装","cat_icon":"https://img.alicdn.com/imgextra/i3/2053469401/O1CN01k8lIxi2JJhtRa60Db-2053469401.png","category_id":"50000852","parent_cid":"16","create_time":null,"update_time":null},{"id":"15","cat_name":"半身裙","cat_icon":"https://img.alicdn.com/imgextra/i1/2053469401/O1CN01JMFIvX2JJhtfK3U8Q-2053469401.png","category_id":"1623","parent_cid":"16","create_time":null,"update_time":null},{"id":"16","cat_name":"牛仔裤","cat_icon":"https://img.alicdn.com/imgextra/i1/2053469401/TB2zD.LtXmWBuNjSspdXXbugXXa-2053469401.png","category_id":"162205","parent_cid":"16","create_time":null,"update_time":null},{"id":"17","cat_name":"阔腿裤","cat_icon":"https://img.alicdn.com/imgextra/i1/2053469401/O1CN01UqAN9K2JJhtYaCmil-2053469401.png","category_id":"162201","parent_cid":"16","create_time":null,"update_time":null},{"id":"18","cat_name":"小脚裤","cat_icon":"https://img.alicdn.com/imgextra/i2/2053469401/O1CN01QFWLl52JJhuo9KDrJ-2053469401.png","category_id":"3035","parent_cid":"16","create_time":null,"update_time":null},{"id":"19","cat_name":"棉衣/棉服","cat_icon":"https://img.alicdn.com/imgextra/i2/2053469401/O1CN01Z8HerC2JJhtfK4DoP-2053469401.png","category_id":"50008900","parent_cid":"16","create_time":null,"update_time":null}]
     */

    private String id;
    private String cat_name;
    private String cat_icon;
    private String category_id;
    private String parent_cid;
    private Object create_time;
    private Object update_time;
    private List<CateBean> cate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_icon() {
        return cat_icon;
    }

    public void setCat_icon(String cat_icon) {
        this.cat_icon = cat_icon;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getParent_cid() {
        return parent_cid;
    }

    public void setParent_cid(String parent_cid) {
        this.parent_cid = parent_cid;
    }

    public Object getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Object create_time) {
        this.create_time = create_time;
    }

    public Object getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Object update_time) {
        this.update_time = update_time;
    }

    public List<CateBean> getCate() {
        return cate;
    }

    public void setCate(List<CateBean> cate) {
        this.cate = cate;
    }

    public static class CateBean {
        /**
         * id : 2
         * cat_name : 外套
         * cat_icon : https://img.alicdn.com/imgextra/i4/2053469401/O1CN012JJhsoAOrYNlKbb-2053469401.jpg
         * category_id : 50010548
         * parent_cid : 16
         * create_time : null
         * update_time : null
         */

        private String id;
        private String cat_name;
        private String cat_icon;
        private String category_id;
        private String parent_cid;
        private Object create_time;
        private Object update_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }

        public String getCat_icon() {
            return cat_icon;
        }

        public void setCat_icon(String cat_icon) {
            this.cat_icon = cat_icon;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getParent_cid() {
            return parent_cid;
        }

        public void setParent_cid(String parent_cid) {
            this.parent_cid = parent_cid;
        }

        public Object getCreate_time() {
            return create_time;
        }

        public void setCreate_time(Object create_time) {
            this.create_time = create_time;
        }

        public Object getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(Object update_time) {
            this.update_time = update_time;
        }
    }
}

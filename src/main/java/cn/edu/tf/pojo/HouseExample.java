package cn.edu.tf.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public HouseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPlotIdIsNull() {
            addCriterion("plot_id is null");
            return (Criteria) this;
        }

        public Criteria andPlotIdIsNotNull() {
            addCriterion("plot_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlotIdEqualTo(Long value) {
            addCriterion("plot_id =", value, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdNotEqualTo(Long value) {
            addCriterion("plot_id <>", value, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdGreaterThan(Long value) {
            addCriterion("plot_id >", value, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plot_id >=", value, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdLessThan(Long value) {
            addCriterion("plot_id <", value, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdLessThanOrEqualTo(Long value) {
            addCriterion("plot_id <=", value, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdIn(List<Long> values) {
            addCriterion("plot_id in", values, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdNotIn(List<Long> values) {
            addCriterion("plot_id not in", values, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdBetween(Long value1, Long value2) {
            addCriterion("plot_id between", value1, value2, "plotId");
            return (Criteria) this;
        }

        public Criteria andPlotIdNotBetween(Long value1, Long value2) {
            addCriterion("plot_id not between", value1, value2, "plotId");
            return (Criteria) this;
        }

        public Criteria andHuxingShiIsNull() {
            addCriterion("huxing_shi is null");
            return (Criteria) this;
        }

        public Criteria andHuxingShiIsNotNull() {
            addCriterion("huxing_shi is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingShiEqualTo(Integer value) {
            addCriterion("huxing_shi =", value, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiNotEqualTo(Integer value) {
            addCriterion("huxing_shi <>", value, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiGreaterThan(Integer value) {
            addCriterion("huxing_shi >", value, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiGreaterThanOrEqualTo(Integer value) {
            addCriterion("huxing_shi >=", value, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiLessThan(Integer value) {
            addCriterion("huxing_shi <", value, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiLessThanOrEqualTo(Integer value) {
            addCriterion("huxing_shi <=", value, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiIn(List<Integer> values) {
            addCriterion("huxing_shi in", values, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiNotIn(List<Integer> values) {
            addCriterion("huxing_shi not in", values, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiBetween(Integer value1, Integer value2) {
            addCriterion("huxing_shi between", value1, value2, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingShiNotBetween(Integer value1, Integer value2) {
            addCriterion("huxing_shi not between", value1, value2, "huxingShi");
            return (Criteria) this;
        }

        public Criteria andHuxingTingIsNull() {
            addCriterion("huxing_ting is null");
            return (Criteria) this;
        }

        public Criteria andHuxingTingIsNotNull() {
            addCriterion("huxing_ting is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingTingEqualTo(Integer value) {
            addCriterion("huxing_ting =", value, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingNotEqualTo(Integer value) {
            addCriterion("huxing_ting <>", value, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingGreaterThan(Integer value) {
            addCriterion("huxing_ting >", value, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingGreaterThanOrEqualTo(Integer value) {
            addCriterion("huxing_ting >=", value, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingLessThan(Integer value) {
            addCriterion("huxing_ting <", value, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingLessThanOrEqualTo(Integer value) {
            addCriterion("huxing_ting <=", value, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingIn(List<Integer> values) {
            addCriterion("huxing_ting in", values, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingNotIn(List<Integer> values) {
            addCriterion("huxing_ting not in", values, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingBetween(Integer value1, Integer value2) {
            addCriterion("huxing_ting between", value1, value2, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingTingNotBetween(Integer value1, Integer value2) {
            addCriterion("huxing_ting not between", value1, value2, "huxingTing");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiIsNull() {
            addCriterion("huxing_wei is null");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiIsNotNull() {
            addCriterion("huxing_wei is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiEqualTo(Integer value) {
            addCriterion("huxing_wei =", value, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiNotEqualTo(Integer value) {
            addCriterion("huxing_wei <>", value, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiGreaterThan(Integer value) {
            addCriterion("huxing_wei >", value, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiGreaterThanOrEqualTo(Integer value) {
            addCriterion("huxing_wei >=", value, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiLessThan(Integer value) {
            addCriterion("huxing_wei <", value, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiLessThanOrEqualTo(Integer value) {
            addCriterion("huxing_wei <=", value, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiIn(List<Integer> values) {
            addCriterion("huxing_wei in", values, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiNotIn(List<Integer> values) {
            addCriterion("huxing_wei not in", values, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiBetween(Integer value1, Integer value2) {
            addCriterion("huxing_wei between", value1, value2, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andHuxingWeiNotBetween(Integer value1, Integer value2) {
            addCriterion("huxing_wei not between", value1, value2, "huxingWei");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Integer value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Integer value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Integer value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Integer value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Integer value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Integer> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Integer> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Integer value1, Integer value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorIsNull() {
            addCriterion("current_floor is null");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorIsNotNull() {
            addCriterion("current_floor is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorEqualTo(Integer value) {
            addCriterion("current_floor =", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorNotEqualTo(Integer value) {
            addCriterion("current_floor <>", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorGreaterThan(Integer value) {
            addCriterion("current_floor >", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_floor >=", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorLessThan(Integer value) {
            addCriterion("current_floor <", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorLessThanOrEqualTo(Integer value) {
            addCriterion("current_floor <=", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorIn(List<Integer> values) {
            addCriterion("current_floor in", values, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorNotIn(List<Integer> values) {
            addCriterion("current_floor not in", values, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorBetween(Integer value1, Integer value2) {
            addCriterion("current_floor between", value1, value2, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("current_floor not between", value1, value2, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIsNull() {
            addCriterion("total_floor is null");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIsNotNull() {
            addCriterion("total_floor is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFloorEqualTo(Integer value) {
            addCriterion("total_floor =", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotEqualTo(Integer value) {
            addCriterion("total_floor <>", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorGreaterThan(Integer value) {
            addCriterion("total_floor >", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_floor >=", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLessThan(Integer value) {
            addCriterion("total_floor <", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLessThanOrEqualTo(Integer value) {
            addCriterion("total_floor <=", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIn(List<Integer> values) {
            addCriterion("total_floor in", values, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotIn(List<Integer> values) {
            addCriterion("total_floor not in", values, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorBetween(Integer value1, Integer value2) {
            addCriterion("total_floor between", value1, value2, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("total_floor not between", value1, value2, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTowardsIdIsNull() {
            addCriterion("towards_id is null");
            return (Criteria) this;
        }

        public Criteria andTowardsIdIsNotNull() {
            addCriterion("towards_id is not null");
            return (Criteria) this;
        }

        public Criteria andTowardsIdEqualTo(Integer value) {
            addCriterion("towards_id =", value, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdNotEqualTo(Integer value) {
            addCriterion("towards_id <>", value, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdGreaterThan(Integer value) {
            addCriterion("towards_id >", value, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("towards_id >=", value, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdLessThan(Integer value) {
            addCriterion("towards_id <", value, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdLessThanOrEqualTo(Integer value) {
            addCriterion("towards_id <=", value, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdIn(List<Integer> values) {
            addCriterion("towards_id in", values, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdNotIn(List<Integer> values) {
            addCriterion("towards_id not in", values, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdBetween(Integer value1, Integer value2) {
            addCriterion("towards_id between", value1, value2, "towardsId");
            return (Criteria) this;
        }

        public Criteria andTowardsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("towards_id not between", value1, value2, "towardsId");
            return (Criteria) this;
        }

        public Criteria andRentalIsNull() {
            addCriterion("rental is null");
            return (Criteria) this;
        }

        public Criteria andRentalIsNotNull() {
            addCriterion("rental is not null");
            return (Criteria) this;
        }

        public Criteria andRentalEqualTo(Double value) {
            addCriterion("rental =", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotEqualTo(Double value) {
            addCriterion("rental <>", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalGreaterThan(Double value) {
            addCriterion("rental >", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalGreaterThanOrEqualTo(Double value) {
            addCriterion("rental >=", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalLessThan(Double value) {
            addCriterion("rental <", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalLessThanOrEqualTo(Double value) {
            addCriterion("rental <=", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalIn(List<Double> values) {
            addCriterion("rental in", values, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotIn(List<Double> values) {
            addCriterion("rental not in", values, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalBetween(Double value1, Double value2) {
            addCriterion("rental between", value1, value2, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotBetween(Double value1, Double value2) {
            addCriterion("rental not between", value1, value2, "rental");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNull() {
            addCriterion("payment_id is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("payment_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(Integer value) {
            addCriterion("payment_id =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(Integer value) {
            addCriterion("payment_id <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(Integer value) {
            addCriterion("payment_id >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_id >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(Integer value) {
            addCriterion("payment_id <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(Integer value) {
            addCriterion("payment_id <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<Integer> values) {
            addCriterion("payment_id in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<Integer> values) {
            addCriterion("payment_id not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(Integer value1, Integer value2) {
            addCriterion("payment_id between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_id not between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeIsNull() {
            addCriterion("rental_include is null");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeIsNotNull() {
            addCriterion("rental_include is not null");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeEqualTo(String value) {
            addCriterion("rental_include =", value, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeNotEqualTo(String value) {
            addCriterion("rental_include <>", value, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeGreaterThan(String value) {
            addCriterion("rental_include >", value, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeGreaterThanOrEqualTo(String value) {
            addCriterion("rental_include >=", value, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeLessThan(String value) {
            addCriterion("rental_include <", value, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeLessThanOrEqualTo(String value) {
            addCriterion("rental_include <=", value, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeLike(String value) {
            addCriterion("rental_include like", value, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeNotLike(String value) {
            addCriterion("rental_include not like", value, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeIn(List<String> values) {
            addCriterion("rental_include in", values, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeNotIn(List<String> values) {
            addCriterion("rental_include not in", values, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeBetween(String value1, String value2) {
            addCriterion("rental_include between", value1, value2, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andRentalIncludeNotBetween(String value1, String value2) {
            addCriterion("rental_include not between", value1, value2, "rentalInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeIsNull() {
            addCriterion("house_include is null");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeIsNotNull() {
            addCriterion("house_include is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeEqualTo(String value) {
            addCriterion("house_include =", value, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeNotEqualTo(String value) {
            addCriterion("house_include <>", value, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeGreaterThan(String value) {
            addCriterion("house_include >", value, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeGreaterThanOrEqualTo(String value) {
            addCriterion("house_include >=", value, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeLessThan(String value) {
            addCriterion("house_include <", value, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeLessThanOrEqualTo(String value) {
            addCriterion("house_include <=", value, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeLike(String value) {
            addCriterion("house_include like", value, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeNotLike(String value) {
            addCriterion("house_include not like", value, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeIn(List<String> values) {
            addCriterion("house_include in", values, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeNotIn(List<String> values) {
            addCriterion("house_include not in", values, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeBetween(String value1, String value2) {
            addCriterion("house_include between", value1, value2, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andHouseIncludeNotBetween(String value1, String value2) {
            addCriterion("house_include not between", value1, value2, "houseInclude");
            return (Criteria) this;
        }

        public Criteria andRequireIsNull() {
            addCriterion("`require` is null");
            return (Criteria) this;
        }

        public Criteria andRequireIsNotNull() {
            addCriterion("`require` is not null");
            return (Criteria) this;
        }

        public Criteria andRequireEqualTo(String value) {
            addCriterion("`require` =", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotEqualTo(String value) {
            addCriterion("`require` <>", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireGreaterThan(String value) {
            addCriterion("`require` >", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireGreaterThanOrEqualTo(String value) {
            addCriterion("`require` >=", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLessThan(String value) {
            addCriterion("`require` <", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLessThanOrEqualTo(String value) {
            addCriterion("`require` <=", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLike(String value) {
            addCriterion("`require` like", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotLike(String value) {
            addCriterion("`require` not like", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireIn(List<String> values) {
            addCriterion("`require` in", values, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotIn(List<String> values) {
            addCriterion("`require` not in", values, "require");
            return (Criteria) this;
        }

        public Criteria andRequireBetween(String value1, String value2) {
            addCriterion("`require` between", value1, value2, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotBetween(String value1, String value2) {
            addCriterion("`require` not between", value1, value2, "require");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdIsNull() {
            addCriterion("img_box_id is null");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdIsNotNull() {
            addCriterion("img_box_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdEqualTo(Long value) {
            addCriterion("img_box_id =", value, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdNotEqualTo(Long value) {
            addCriterion("img_box_id <>", value, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdGreaterThan(Long value) {
            addCriterion("img_box_id >", value, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdGreaterThanOrEqualTo(Long value) {
            addCriterion("img_box_id >=", value, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdLessThan(Long value) {
            addCriterion("img_box_id <", value, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdLessThanOrEqualTo(Long value) {
            addCriterion("img_box_id <=", value, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdIn(List<Long> values) {
            addCriterion("img_box_id in", values, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdNotIn(List<Long> values) {
            addCriterion("img_box_id not in", values, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdBetween(Long value1, Long value2) {
            addCriterion("img_box_id between", value1, value2, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andImgBoxIdNotBetween(Long value1, Long value2) {
            addCriterion("img_box_id not between", value1, value2, "imgBoxId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdIsNull() {
            addCriterion("contact_information_id is null");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdIsNotNull() {
            addCriterion("contact_information_id is not null");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdEqualTo(Long value) {
            addCriterion("contact_information_id =", value, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdNotEqualTo(Long value) {
            addCriterion("contact_information_id <>", value, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdGreaterThan(Long value) {
            addCriterion("contact_information_id >", value, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contact_information_id >=", value, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdLessThan(Long value) {
            addCriterion("contact_information_id <", value, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdLessThanOrEqualTo(Long value) {
            addCriterion("contact_information_id <=", value, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdIn(List<Long> values) {
            addCriterion("contact_information_id in", values, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdNotIn(List<Long> values) {
            addCriterion("contact_information_id not in", values, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdBetween(Long value1, Long value2) {
            addCriterion("contact_information_id between", value1, value2, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andContactInformationIdNotBetween(Long value1, Long value2) {
            addCriterion("contact_information_id not between", value1, value2, "contactInformationId");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNull() {
            addCriterion("post_time is null");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNotNull() {
            addCriterion("post_time is not null");
            return (Criteria) this;
        }

        public Criteria andPostTimeEqualTo(Date value) {
            addCriterion("post_time =", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotEqualTo(Date value) {
            addCriterion("post_time <>", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThan(Date value) {
            addCriterion("post_time >", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("post_time >=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThan(Date value) {
            addCriterion("post_time <", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThanOrEqualTo(Date value) {
            addCriterion("post_time <=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeIn(List<Date> values) {
            addCriterion("post_time in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotIn(List<Date> values) {
            addCriterion("post_time not in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeBetween(Date value1, Date value2) {
            addCriterion("post_time between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotBetween(Date value1, Date value2) {
            addCriterion("post_time not between", value1, value2, "postTime");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
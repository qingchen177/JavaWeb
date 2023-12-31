package top.qingchen.basicweb.common.constant.myenum;

/**
 * @author qingchen
 * @date 17/10/2023 下午 4:16
 */

public enum SpringTransactionalPropagation {
    /**
     * 如果当前没有事务，则自己新建一个事务，如果当前存在事务则加入这个事务
     * 当A调用B的时候：如果A中没有事务，B中有事务，那么B会新建一个事务；
     * * 如果A中也有事务、B中也有事务，那么B会加入到A中去，变成一个事务，这时，要么都成功，要么都失败。
     * * （假如A中有2个SQL，B中有两个SQL，那么这四个SQL会变成一个SQL，要么都成功，要么都失败）
     */
    REQUIRED(0),

    /**
     * 当前存在事务，则加入当前事务，如果当前没有事务，就以非事务方法执行
     * 如果A中有事务，则B方法的事务加入A事务中，成为一个事务（一起成功，一起失败），
     * * 如果A中没有事务，那么B就以非事务方式运行（执行完直接提交）
     */
    SUPPORTS(1),
    /**
     * 当前存在事务，则加入当前事务，如果当前事务不存在，则抛出异常。
     * 如果A中有事务，则B方法的事务加入A事务中，成为一个事务（一起成功，一起失败）；
     * * 如果A中没有事务，B中有事务，那么B就直接抛异常了，意思是B必须要支持回滚的事务中运行
     */
    MANDATORY(2),
    /**
     * 创建一个新事务，如果存在当前事务，则挂起该事务。
     * B会新建一个事务，A和B事务互不干扰，他们出现问题回滚的时候，也都只回滚自己的事务
     */
    REQUIRES_NEW(3),
    /**
     * 以非事务方式执行,如果当前存在事务，则挂起当前事务
     * 被调用者 B会以非事务方式运行（直接提交），如果当前有事务，
     * * 也就是A中有事务，A会被挂起（不执行，等待B执行完，返回）；A和B出现异常需要回滚，互不影响
     */
    NOT_SUPPORTED(4),
    /**
     * 如果当前没有事务存在，就以非事务方式执行；如果有，就抛出异常。就是B从不以事务方式运行
     * A中不能有事务，如果没有，B就以非事务方式执行，如果A存在事务，那么直接抛异常
     */
    NEVER(5),
    /**
     * 如果当前事务存在，则在嵌套事务中执行，否则REQUIRED的操作一样(开启一个事务)
     * 如果A中没有事务，那么B创建一个事务执行，如果A中也有事务，那么B会会把事务嵌套在里面。
     */
    NESTED(6);


    /**
     * NESTED嵌套事务
     * 和REQUIRES_NEW的区别
     * REQUIRES_NEw是新建一个事务并且新开启的这个事务与原有事务无关，而NESTED则是当前存在事务时（我们把当前事务称之为父事务）会开启一个嵌套事务（称之为一个子事务)。
     * 在NESTED情况下父事务回滚时，子事务也会回滚，而在REQUIRES_NEw情况下，原有事务回滚，不会影响新开启的事务。
     * 和REQUIRED的区别
     * REQUIRED情况下，调用方存在事务时，则被调用方和调用方使用同一事务，那么被调用方出现异常时，由于共用一个事务，所以无论调用方是否catch其异常，
     * 事务都会回滚而在NESTED情况下，被调用方发生异常时，调用方可以catch其异常，这样只有子事务回滚，父事务不受影响
     */

    private final int value;

    SpringTransactionalPropagation(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}

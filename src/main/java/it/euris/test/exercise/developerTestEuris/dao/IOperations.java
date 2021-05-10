package it.euris.test.exercise.developerTestEuris.dao;

public interface IOperations {

    /**
     * Sum from a external values
     * @param values Ex (5p 17s 8d + 3p 4s 10d)
     * @return result of the operation
     */
    String sum(String values);

    /**
     * Subtraction from a external values
     * @param values Ex (5p 17s 8d - 3p 4s 10d)
     * @return result of the operation
     */
    String subtraction(String values);

    /**
     * Moltiplication from a external values
     * @param values Ex (5p 17s 8d * 2)
     * @return result of the operation
     */
    String moltiplication(String values);

    /**
     * Division from a external values
     * @param operandOne Ex (18p 16s 1d)
     * @param operandTwo Ex (15)
     * @return Result of the operation
     */
    String division(String operandOne, String operandTwo);
}

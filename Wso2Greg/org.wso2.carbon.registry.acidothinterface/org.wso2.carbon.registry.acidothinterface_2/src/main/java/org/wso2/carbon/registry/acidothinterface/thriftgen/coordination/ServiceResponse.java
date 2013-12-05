/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.wso2.carbon.registry.acidothinterface.thriftgen.coordination;


import org.apache.thrift.TEnum;

public enum ServiceResponse implements TEnum {
  prepared(0),
  aborted(1),
  readOnly(2),
  commited(3);

  private final int value;

  private ServiceResponse(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static ServiceResponse findByValue(int value) { 
    switch (value) {
      case 0:
        return prepared;
      case 1:
        return aborted;
      case 2:
        return readOnly;
      case 3:
        return commited;
      default:
        return null;
    }
  }
}

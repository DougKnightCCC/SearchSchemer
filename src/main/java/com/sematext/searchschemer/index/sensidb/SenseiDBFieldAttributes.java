package com.sematext.searchschemer.index.sensidb;

import com.sematext.searchschemer.client.ConfigurationType;
import com.sematext.searchschemer.index.AbstractFieldAttributes;

/**
 * Fields from SenseiDB table configuration.
 * 
 * @author Sematext
 * 
 */
public final class SenseiDBFieldAttributes extends AbstractFieldAttributes {
  private String index;
  private String store;

  /**
   * Constructor.
   */
  public SenseiDBFieldAttributes() {
    super();
    this.index = Analyzed.NO.toString();
    this.store = Stored.NO.toString();
  }

  /**
   * Create field attribute.
   * 
   * @param name
   *          field name
   * @param type
   *          attribute type
   * @param analyzed
   *          is field analyzed (value 'no', 'analyzed' or 'not_analyzed')
   * @param stored
   *          is field stored (value 'no' or 'yes')
   */
  public SenseiDBFieldAttributes(String name, String type, String index, String store) {
    this();
    this.name = name;
    this.type = type;
    this.index = index;
    this.store = store;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean analyzed() {
    if (Analyzed.ANALYZED.toString().compareTo(index.toUpperCase()) == 0) {
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean store() {
    if (Stored.YES.toString().compareTo(store.toUpperCase()) == 0) {
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean indexed() {
    if (Analyzed.NO.toString().compareTo(index.toUpperCase()) == 0) {
      return false;
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean multiValued() {
    return true; // always true in SenseiDB as in Lucene
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ConfigurationType getConfigurationType() {
    return ConfigurationType.SENSEIDB;
  }

  public void setIndex(String index) {
    this.index = index;
  }

  public void setStore(String store) {
    this.store = store;
  }
}

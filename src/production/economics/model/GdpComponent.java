package economics.model;

import java.math.*;

/**
 * Date: Sep 10, 2010
 * Time: 5:28:41 PM
 */
public class GdpComponent {
   private BigDecimal personalConsumption;
   private BigDecimal governmentExpenditure;
   private BigDecimal businessInvestment;
   private BigDecimal residentialInvestment;
   private BigDecimal exports;
   private BigDecimal imports;
   private BigDecimal deflator;

   public GdpComponent(BigDecimal personalConsumption,
                       BigDecimal governmentExpenditure,
                       BigDecimal businessInvestment,
                       BigDecimal residentialInvestment,
                       BigDecimal exports,
                       BigDecimal imports,
                       BigDecimal deflator) {
      this.personalConsumption = personalConsumption;
      this.governmentExpenditure = governmentExpenditure;
      this.businessInvestment = businessInvestment;
      this.residentialInvestment = residentialInvestment;
      this.exports = exports;
      this.imports = imports;
      this.deflator = deflator;
   }

   public BigDecimal getPersonalConsumption() {
      return personalConsumption;
   }

   public BigDecimal getGovernmentExpenditure() {
      return governmentExpenditure;
   }

   public BigDecimal getBusinessInvestment() {
      return businessInvestment;
   }

   public BigDecimal getResidentialInvestment() {
      return residentialInvestment;
   }

   public BigDecimal getExports() {
      return exports;
   }

   public BigDecimal getImports() {
      return imports;
   }

   public BigDecimal getDeflator() {
      return deflator;
   }

   public BigDecimal calculate() {
      return personalConsumption
      .add(governmentExpenditure)
      .add(businessInvestment)
      .add(residentialInvestment)
      .add(exports)
      .subtract(imports)
      .multiply(calculateDeflator());
   }

   private BigDecimal calculateDeflator() {
       return new BigDecimal("100.00").divide(deflator, 3, RoundingMode.HALF_UP);
   }
}

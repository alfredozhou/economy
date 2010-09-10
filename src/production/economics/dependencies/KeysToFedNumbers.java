package economics.dependencies;

/**
 * Date: Sep 10, 2010
 * Time: 11:52:13 AM
 */
public enum KeysToFedNumbers {
   residential("PRFICA"),
   business("PNFICA"),
   government("AFEXPND"),
   personalConsumption("PCECA"),
   exports("EXPGSA"),
   imports("IMPGSA"),
   deflator("GDPDEF"),
   GDP("GDPCA")
   ;

   private String keyName;
   private KeysToFedNumbers(String keyName) {
      this.keyName = keyName;
   }

   public String getSeriesName() {
      return keyName;
   }
}

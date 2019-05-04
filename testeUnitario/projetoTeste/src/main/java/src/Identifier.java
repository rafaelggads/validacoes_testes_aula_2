package src;


public class Identifier {
   public boolean validateIdentifier(String s) {
      boolean result = false;
      if(s != null){
         char achar;
         boolean valid_id = false;
         achar = s.charAt(0);
         valid_id = valid_s(achar);
         if (s.length() > 1) {
            achar = s.charAt(1);
            int i = 1;
            while (i < s.length()) {
               achar = s.charAt(i);
               if (!valid_f(achar))
                  valid_id = false;
               i++;
            }
         }

         if (valid_id && (s.length() >= 1) && (s.length() < 6)){
            result = true;
         }

      }else{
         throw new NullPointerException();
      }
      return result;
   }

   public boolean valid_s(char ch) {
      if (((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z')))
         return true;
      else
         return false;
   }

   public boolean valid_f(char ch) {
      if (((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z')) || ((ch >= '0') && (ch <= '9')))
         return true;
      else
         return false;
   }

   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("Uso: identifier.Identifier <string>");
      } else {
         Identifier id = new Identifier();
         if (id.validateIdentifier(args[0])) {
            System.out.println("Válido");
         } else {
            System.out.println("Inválido");
         }
      }
   }
}

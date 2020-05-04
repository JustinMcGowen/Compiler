//Class for easily keeping track of each variable with type, name and value
public class ASTNode{
    public String type;
    public String name;
    public String value;
    public String currRegister;

    public ASTNode leftRef;
    public ASTNode rightRef;

    public String temp;

    public ASTNode(String t){
      temp = t;
    }
    public ASTNode(String t, String v, String n){
      temp=n;
      type = t;
      value = v;
      name = n;
    }

    public String toString() {
      String l = "",r = "";
      if(leftRef != null){
        l = leftRef.toString();
      }
      if(rightRef != null){
        r = rightRef.toString();
      }
      return temp +"<"+ l+"|"+r;
    }
    public String prettyString(){
      String[] tree = {temp};
      String[] tmp;
      if(leftRef != null){

      }
      if(rightRef != null){

      }
      return temp;
    }

    public String getTypeFromChild(){
      String r = "", l="";
      if(type != null && type != "" && type !="OP"){
        return type;
      }else{
        if(leftRef != null){
          l = leftRef.getTypeFromChild();
        }
        if(rightRef != null){
          r = rightRef.getTypeFromChild();
        }

        if(l != ""){
          return l;
        }else if(r!=""){
          return r;
        }else{
          return "";
        }
      }
    }
}

//Class for easily keeping track of each variable with type, name and value
public class SymbolTableItem{
    public String type;
    public String name;
    public String value;

    public SymbolTableItem(String inpType, String inpName, String inpValue){
        this.type = inpType;
        this.name = inpName;
        this.value = inpValue;
    }
    public SymbolTableItem(String inpType, String inpName){
        this.type = inpType;
        this.name = inpName;
	this.value = null;
    }
}

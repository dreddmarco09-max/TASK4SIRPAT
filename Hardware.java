abstract class Hardware {
    protected int id;
    protected String brand;
    protected int spec;

    
    public Hardware(int id, String brand, int spec) {
        this.id = id;
        this.brand = brand;
        this.spec = spec;
    
    }

    
    public abstract String getInterpretation();

    
    
    public int getSpec() {
        return spec;
   
    }
}

class Laptop extends Hardware {
    public Laptop(int id, String brand, int spec) {
        super(id, brand, spec);
    
    }

    
    @Override
    public String getInterpretation() {
       
        
        return id + "\t" + brand + "\t\t" + spec + "\tLaptop\t" + spec + "GB RAM";
    
    }
}




class Phone extends Hardware {
    public Phone(int id, String brand, int spec) {
        super(id, brand, spec);
    
    }

   
    
    @Override
    public String getInterpretation() {
        
        return id + "\t" + brand + "\t\t" + spec + "\tPhone\t" + spec + " Megapixels";
    
    }
}

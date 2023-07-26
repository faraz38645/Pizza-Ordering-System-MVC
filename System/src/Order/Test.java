/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;



/**
 *
 * @author AAUM
 */
public class Test {
    
    pizza njf;
    
    int match=0;
    
    public Test(pizza jf){
       
        this.njf =jf;
        
    }
    
     
   
//     LOGIN login; //for intializing LOGIN
//     public Test(LOGIN login){
//     this.login =login;
//     
//     }
     
     
    String user;
    String pass;
    
    int id;
    Test(String username, String password) {
        this.user =username;
        this.pass =password;
    }
    
    Reg reg;
    Test(Reg aThis) {
        this.reg = aThis;
    }
    
    //Reg t= new Reg(this);
    
    
    
    public void Add(){
        System.out.println("working");
    }
    
    public void Addrow(){
        
        njf.Add(new Object[] {
            njf.item,
            njf.fla,
            njf.ex_name,
            njf.price,
            njf.qty,
            njf.drink_name,
            njf.total,
        
        });
       
       
        
        
        System.out.println("working"+njf.fla+njf.total);//Working 
    }
    
    
    
    
      

   public int Addtot(){
            int res=0;
           for (int i=njf.rows-1;i<njf.rows;i++){
               res += njf.calculating;
           }
        
           System.out.println("oky: "+ res);
           
           return res;
      
        
        
        //System.out.println("working"+njf.fla+njf.total);//Working 
    }
       
      
    
   public int remtot(){
           
           int res;
           res = njf.res1 - njf.removing;
           
           return res;
      
        
        
        //System.out.println("working"+njf.fla+njf.total);//Working 
    }
    
   
   public int getbal(){
           int res;
           res= njf.pay1 -njf.total1;
           
           return res;
      
        
        
        //System.out.println("working"+njf.fla+njf.total);//Working 
    }
    public void setid(int id) {
        this.id = id;
    }
     public int getid() {
        return id;
    }
     
  
    
    
//   public int login() throws SQLException, ClassNotFoundException{
//       
//        user =login.username;
//        pass= login.password;
//        CheckLogin model1 = new CheckLogin(user,pass);
//       
//        match= model1.log();
//        
//         setid(model1.Emp_id);
//       
//         
//         
//         
//        System.out.println("hello id"+this.getid());
//       
//       return match;
//        
//        
//        
//    }
   
    int a =this.getid();
    
    public int swt(){
          return a;
        
        
    }
   
   
   
   

    
    
   
   
    
    
    
        
    
    
    
   
    
    
}

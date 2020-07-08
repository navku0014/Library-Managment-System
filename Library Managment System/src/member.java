
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen Sheoran
 */
public class member {
    private Integer memberid;
    private String membername;
    private Date dateofjoining;
    
    public member(){
        
    }

    public member(Integer memberid, String membername, Date dateofjoining) {
        this.memberid = memberid;
        this.membername = membername;
        this.dateofjoining = dateofjoining;
    }

    public Date getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(Date dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }
    
}

package Java_Contact_List;

import java.util.Objects;

public class Contact implements Comparable {
    private String name;
    private String tlfn;
    private String address;

    public Contact(String name, String tlfn, String address) {
        this.name = name;
        this.tlfn = tlfn;
        this.address = address;
    }

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTlfn() {
        return tlfn;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("""
                             %s : %s
                             Address: %s
                             """, this.name, this.tlfn, this.address);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int compareTo(Object o) {
        Contact c = (Contact) o;
        /*
        int iniThis = this.getNombre().charAt(0);
        int iniC = c.getNombre().charAt(0);
        
        if (iniThis > iniC) {
            return 1;
        } else if (iniThis < iniC){
            return -1;
        } else {
            return 0;
        }
*/
        return this.name.compareToIgnoreCase(c.getName());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Student
 */
@Entity
@SecondaryTables({
    @SecondaryTable(name="address_table"),
    @SecondaryTable(name="picture_table")
})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue
    private Integer id;
    
    @Column(name="name", nullable = false, length = 255)
    private String name;
    
    @Column(name="nickname", nullable = false, length = 255)
    private String nickname;
    
    @Column(table="address_table", name="name", nullable = false, length = 255)
    private String address;
    
    @Lob
    @Column(table="picture_table", name="picture")
    private byte[] picture;

    public Person() {
    }

    public Person(Integer id, String name, String nickname, String address, byte[] picture) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.address = address;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entities.Person[ id=" + id + " ]";
    }
    
}

package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

     @Entity
     public class strishka {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long Idd;
     private String srishkaType;
     private int narxi;

         public strishka() {
         }

         public strishka(String srishkaType, int narxi) {
             this.srishkaType = srishkaType;
             this.narxi = narxi;
         }

         public int getNarxi() {
             return narxi;
         }

         public void setNarxi(int narxi) {
             this.narxi = narxi;
         }

         public Long getId() {
             return Idd;
         }

         public void setId(Integer id) {
             this.Idd = id;
         }

         public String getSrishkaType() {
             return srishkaType;
         }

         public void setSrishkaType(String srishkaType) {
             this.srishkaType = srishkaType;
         }
     }

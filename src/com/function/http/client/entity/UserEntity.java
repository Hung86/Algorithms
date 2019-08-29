package com.function.http.client.entity;

public class UserEntity
{
   private String domain = "";
   private String userId = "";  
   private String userName = "";
   private String department = "";
   private String email = "";
   private String userFullName = "";
   private String homeDirectory = "";
   private String dualFactor = "";
   private String enrollment = "";
   private String[] orgUnit = new String[0];
   private String userDistinguishedName = "";
   private String[] groupDistinguishedName = new String[0];
   private String[] memberOf = new String[0];
   private String userRight = "";

   public UserEntity() {
   }
   /**
    * @return the domain
    */
   public String getDomain()
   {
      return domain;
   }
   /**
    * @param domain the domain to set
    */
   public void setDomain(String domain)
   {
      this.domain = domain;
   }
   /**
    * @return the userId
    */
   public String getUserId()
   {
      return userId;
   }
   /**
    * @param userId the userId to set
    */
   public void setUserId(String userId)
   {
      this.userId = userId;
   }
   /**
    * @return the userName
    */
   public String getUserName()
   {
      return userName;
   }
   /**
    * @param userName the userName to set
    */
   public void setUserName(String userName)
   {
      this.userName = userName;
   }
   /**
    * @return the department
    */
   public String getDepartment()
   {
      return department;
   }
   /**
    * @param department the department to set
    */
   public void setDepartment(String department)
   {
      this.department = department;
   }
   /**
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }
   /**
    * @param email the email to set
    */
   public void setEmail(String email)
   {
      this.email = email;
   }
   /**
    * @return the userFullName
    */
   public String getUserFullName()
   {
      return userFullName;
   }
   /**
    * @param userFullName the userFullName to set
    */
   public void setUserFullName(String userFullName)
   {
      this.userFullName = userFullName;
   }
   /**
    * @return the homeDirectory
    */
   public String getHomeDirectory()
   {
      return homeDirectory;
   }
   /**
    * @param homeDirectory the homeDirectory to set
    */
   public void setHomeDirectory(String homeDirectory)
   {
      this.homeDirectory = homeDirectory;
   }
   /**
    * @return the dualFactor
    */
   public String getDualFactor()
   {
      return dualFactor;
   }
   /**
    * @param dualFactor the dualFactor to set
    */
   public void setDualFactor(String dualFactor)
   {
      this.dualFactor = dualFactor;
   }
   /**
    * @return the enrollment
    */
   public String getEnrollment()
   {
      return enrollment;
   }
   /**
    * @param enrollment the enrollment to set
    */
   public void setEnrollment(String enrollment)
   {
      this.enrollment = enrollment;
   }
   /**
    * @return the orgUnit
    */
   public String[] getOrgUnit()
   {
      return orgUnit;
   }
   /**
    * @param orgUnit the orgUnit to set
    */
   public void setOrgUnit(String[] orgUnit)
   {
      this.orgUnit = orgUnit;
   }
   /**
    * @return the userDistinguishedName
    */
   public String getUserDistinguishedName()
   {
      return userDistinguishedName;
   }
   /**
    * @param userDistinguishedName the userDistinguishedName to set
    */
   public void setUserDistinguishedName(String userDistinguishedName)
   {
      this.userDistinguishedName = userDistinguishedName;
   }
   /**
    * @return the groupDistinguishedName
    */
   public String[] getGroupDistinguishedName()
   {
      return groupDistinguishedName;
   }
   /**
    * @param groupDistinguishedName the groupDistinguishedName to set
    */
   public void setGroupDistinguishedName(String[] groupDistinguishedName)
   {
      this.groupDistinguishedName = groupDistinguishedName;
   }
   /**
    * @return the memberOf
    */
   public String[] getMemberOf()
   {
      return memberOf;
   }
   /**
    * @param memberOf the memberOf to set
    */
   public void setMemberOf(String[] memberOf)
   {
      this.memberOf = memberOf;
   }
   
   /**
    * @return the userRight
    */
   public String getUserRight()
   {
      return userRight;
   }
   /**
    * @param userRight the userRight to set
    */
   public void setUserRight(String userRight)
   {
      this.userRight = userRight;
   }
   
   public String generateGroupDistinguishedNameInXML() {
      StringBuilder distinguishedPathXML = new StringBuilder();
      
      if ((groupDistinguishedName != null) && (groupDistinguishedName.length > 0)) {
          distinguishedPathXML.append("<OUGroups>");
          for (String item : groupDistinguishedName) {
              distinguishedPathXML.append("<OUGroup>");
              distinguishedPathXML.append(item);
              distinguishedPathXML.append("</OUGroup>");
          }
          distinguishedPathXML.append("</OUGroups>");
      }
      
      return distinguishedPathXML.toString();
  }
  
  public String generateGroupMemeberOfInXML() {
      StringBuilder groupMemberOfXML = new StringBuilder();   
      if ((memberOf != null) && (memberOf.length > 0)) {
          groupMemberOfXML.append("<Groups>");
          for (String item : memberOf) {
              groupMemberOfXML.append("<Group>");
              groupMemberOfXML.append(item);
              groupMemberOfXML.append("</Group>");
          }
          groupMemberOfXML.append("</Groups>");
      }
      
      return groupMemberOfXML.toString();
  }
  
//   public String toJsonString() {
//      ObjectMapper mapper = new ObjectMapper();
//      mapper.enable(SerializationFeature.INDENT_OUTPUT);
//      String json = "";
//      try
//      {
//         json = mapper.writeValueAsString(this);
//      }
//      catch (JsonProcessingException e)
//      {
//         e.printStackTrace();
//      }
//      return json;
//   }
//   
  @Override
  public String toString() {
     return "[userName] = " + userName;
  }
}

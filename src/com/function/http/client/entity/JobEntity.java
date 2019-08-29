package com.function.http.client.entity;

import java.util.ArrayList;
import java.util.List;

public class JobEntity implements Comparable<JobEntity>{
   private String jobId;
   private String jobName;
   private int jobTotalPages;
   private int jobNbColorPages;
   private int jobNbCopy;
   private String jobPaperSize;
   private String jobSize;
   private int jobAllowed;
   private float jobCost;
   private boolean jobDuplex;
   private String jobDate;
   private String jobDateLimit;
   private String jobServerName;
   private String jobServerIpAddress;
   private int jobServerPort;
   private boolean deptJob;
   private boolean isSelected = false;
   private String displayField;
   private boolean jobDeny;
   private boolean forcedBW;
   private boolean forcedDuplex;
   private boolean forcedEconoMode;
   private boolean notification;
   private int printRuleRights;
   private String jobCurrencySymbol;
   private String jobCompatibilityStatus;
   private String jobVoid;
   private List<String> notificationMessages = new ArrayList<String>();
   
   /**
    * @return the jobId
    */
   public String getJobId()
   {
      return jobId;
   }

   /**
    * @param jobId the jobId to set
    */
   public void setJobId(String jobId)
   {
      this.jobId = jobId;
   }

   /**
    * @return the jobName
    */
   public String getJobName()
   {
      return jobName;
   }

   /**
    * @param jobName the jobName to set
    */
   public void setJobName(String jobName)
   {
      this.jobName = jobName;
   }

   /**
    * @return the jobTotalPages
    */
   public int getJobTotalPages()
   {
      return jobTotalPages;
   }

   /**
    * @param jobTotalPages the jobTotalPages to set
    */
   public void setJobTotalPages(int jobTotalPages)
   {
      this.jobTotalPages = jobTotalPages;
   }

   /**
    * @return the jobNbColorPages
    */
   public int getJobNbColorPages()
   {
      return jobNbColorPages;
   }

   /**
    * @param jobNbColorPages the jobNbColorPages to set
    */
   public void setJobNbColorPages(int jobNbColorPages)
   {
      this.jobNbColorPages = jobNbColorPages;
   }

   /**
    * @return the jobNbCopy
    */
   public int getJobNbCopy()
   {
      return jobNbCopy;
   }

   /**
    * @param jobNbCopy the jobNbCopy to set
    */
   public void setJobNbCopy(int jobNbCopy)
   {
      this.jobNbCopy = jobNbCopy;
   }

   /**
    * @return the jobPaperSize
    */
   public String getJobPaperSize()
   {
      return jobPaperSize;
   }

   /**
    * @param jobPaperSize the jobPaperSize to set
    */
   public void setJobPaperSize(String jobPaperSize)
   {
      this.jobPaperSize = jobPaperSize;
   }

   /**
    * @return the jobSize
    */
   public String getJobSize()
   {
      return jobSize;
   }

   /**
    * @param jobSize the jobSize to set
    */
   public void setJobSize(String jobSize)
   {
      this.jobSize = jobSize;
   }

   /**
    * @return the jobAllowed
    */
   public int getJobAllowed()
   {
      return jobAllowed;
   }

   /**
    * @param jobAllowed the jobAllowed to set
    */
   public void setJobAllowed(int jobAllowed)
   {
      this.jobAllowed = jobAllowed;
   }

   /**
    * @return the jobCost
    */
   public float getJobCost()
   {
      return jobCost;
   }

   /**
    * @param jobCost the jobCost to set
    */
   public void setJobCost(float jobCost)
   {
      this.jobCost = jobCost;
   }

   /**
    * @return the jobDuplex
    */
   public boolean isJobDuplex()
   {
      return jobDuplex;
   }

   /**
    * @param jobDuplex the jobDuplex to set
    */
   public void setJobDuplex(boolean jobDuplex)
   {
      this.jobDuplex = jobDuplex;
   }

   /**
    * @return the jobDate
    */
   public String getJobDate()
   {
      return jobDate;
   }

   /**
    * @param jobDate the jobDate to set
    */
   public void setJobDate(String jobDate)
   {
      this.jobDate = jobDate;
   }

   /**
    * @return the jobDateLimit
    */
   public String getJobDateLimit()
   {
      return jobDateLimit;
   }

   /**
    * @param jobDateLimit the jobDateLimit to set
    */
   public void setJobDateLimit(String jobDateLimit)
   {
      this.jobDateLimit = jobDateLimit;
   }

   /**
    * @return the jobServerName
    */
   public String getJobServerName()
   {
      return jobServerName;
   }

   /**
    * @param jobServerName the jobServerName to set
    */
   public void setJobServerName(String jobServerName)
   {
      this.jobServerName = jobServerName;
   }

   /**
    * @return the jobServerIpAddress
    */
   public String getJobServerIpAddress()
   {
      return jobServerIpAddress;
   }

   /**
    * @param jobServerIpAddress the jobServerIpAddress to set
    */
   public void setJobServerIpAddress(String jobServerIpAddress)
   {
      this.jobServerIpAddress = jobServerIpAddress;
   }

   /**
    * @return the jobServerPort
    */
   public int getJobServerPort()
   {
      return jobServerPort;
   }

   /**
    * @param jobServerPort the jobServerPort to set
    */
   public void setJobServerPort(int jobServerPort)
   {
      this.jobServerPort = jobServerPort;
   }

   /**
    * @return the deptJob
    */
   public boolean isDeptJob()
   {
      return deptJob;
   }

   /**
    * @param deptJob the deptJob to set
    */
   public void setDeptJob(boolean deptJob)
   {
      this.deptJob = deptJob;
   }

   /**
    * @return the isSelected
    */
   public boolean isSelected()
   {
      return isSelected;
   }

   /**
    * @param isSelected the isSelected to set
    */
   public void setSelected(boolean isSelected)
   {
      this.isSelected = isSelected;
   }

   /**
    * @return the displayField
    */
   public String getDisplayField()
   {
      return displayField;
   }

   /**
    * @param displayField the displayField to set
    */
   public void setDisplayField(String displayField)
   {
      this.displayField = displayField;
   }

   /**
    * @return the jobDeny
    */
   public boolean isJobDeny()
   {
      return jobDeny;
   }

   /**
    * @param jobDeny the jobDeny to set
    */
   public void setJobDeny(boolean jobDeny)
   {
      this.jobDeny = jobDeny;
   }

   /**
    * @return the forcedBW
    */
   public boolean isForcedBW()
   {
      return forcedBW;
   }

   /**
    * @param forcedBW the forcedBW to set
    */
   public void setForcedBW(boolean forcedBW)
   {
      this.forcedBW = forcedBW;
   }

   /**
    * @return the forcedDuplex
    */
   public boolean isForcedDuplex()
   {
      return forcedDuplex;
   }

   /**
    * @param forcedDuplex the forcedDuplex to set
    */
   public void setForcedDuplex(boolean forcedDuplex)
   {
      this.forcedDuplex = forcedDuplex;
   }

   /**
    * @return the forcedEconoMode
    */
   public boolean isForcedEconoMode()
   {
      return forcedEconoMode;
   }

   /**
    * @param forcedEconoMode the forcedEconoMode to set
    */
   public void setForcedEconoMode(boolean forcedEconoMode)
   {
      this.forcedEconoMode = forcedEconoMode;
   }

   /**
    * @return the notification
    */
   public boolean isNotification()
   {
      return notification;
   }

   /**
    * @param notification the notification to set
    */
   public void setNotification(boolean notification)
   {
      this.notification = notification;
   }

   /**
    * @return the printRuleRights
    */
   public int getPrintRuleRights()
   {
      return printRuleRights;
   }

   /**
    * @param printRuleRights the printRuleRights to set
    */
   public void setPrintRuleRights(int printRuleRights)
   {
      this.printRuleRights = printRuleRights;
   }

   /**
    * @return the jobCurrencySymbol
    */
   public String getJobCurrencySymbol()
   {
      return jobCurrencySymbol;
   }

   /**
    * @param jobCurrencySymbol the jobCurrencySymbol to set
    */
   public void setJobCurrencySymbol(String jobCurrencySymbol)
   {
      this.jobCurrencySymbol = jobCurrencySymbol;
   }

   /**
    * @return the jobCompatibilityStatus
    */
   public String getJobCompatibilityStatus()
   {
      return jobCompatibilityStatus;
   }

   /**
    * @param jobCompatibilityStatus the jobCompatibilityStatus to set
    */
   public void setJobCompatibilityStatus(String jobCompatibilityStatus)
   {
      this.jobCompatibilityStatus = jobCompatibilityStatus;
   }

   /**
    * @return the jobVoid
    */
   public String getJobVoid()
   {
      return jobVoid;
   }

   /**
    * @param jobVoid the jobVoid to set
    */
   public void setJobVoid(String jobVoid)
   {
      this.jobVoid = jobVoid;
   }

   /**
    * @return the notificationMessages
    */
   public List<String> getNotificationMessages()
   {
      return notificationMessages;
   }

   /**
    * @param notificationMessages the notificationMessages to set
    */
   public void setNotificationMessages(List<String> notificationMessages)
   {
      this.notificationMessages = notificationMessages;
   }

   @Override
   public int compareTo(JobEntity o) {  
       return jobServerIpAddress.compareTo(o.jobServerIpAddress);
   }
   
   public boolean ruleApplied() {
      try {
          if(isForcedBW() || isForcedDuplex() || isForcedEconoMode()) {
              return true;
          }
          
      } catch (Exception e) {
         e.printStackTrace();
      }
      return false;
  }
}

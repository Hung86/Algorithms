package com.function.http.client.entity;

public class ErrorEntity
{
   private int httpCode;
   private String errorCode;
   private String errorMessage;
   private String date;
   
   /**
    * @return the httpCode
    */
   public int getHttpCode()
   {
      return httpCode;
   }
   /**
    * @param httpCode the httpCode to set
    */
   public void setHttpCode(int httpCode)
   {
      this.httpCode = httpCode;
   }
   /**
    * @return the errorCode
    */
   public String getErrorCode()
   {
      return errorCode;
   }
   /**
    * @param errorCode the errorCode to set
    */
   public void setErrorCode(String errorCode)
   {
      this.errorCode = errorCode;
   }
   /**
    * @return the errorMessage
    */
   public String getErrorMessage()
   {
      return errorMessage;
   }
   /**
    * @param errorMessage the errorMessage to set
    */
   public void setErrorMessage(String errorMessage)
   {
      this.errorMessage = errorMessage;
   }
   /**
    * @return the date
    */
   public String getDate()
   {
      return date;
   }
   /**
    * @param date the date to set
    */
   public void setDate(String date)
   {
      this.date = date;
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
//         json = "{\"message\":\"An internal error occurred\"}";
//      }
//      return json;
//   }
}

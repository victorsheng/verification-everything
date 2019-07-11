# verification-everything
spring-retry
参考:
https://www.baeldung.com/spring-retry
https://stackoverflow.com/questions/41897396/recover-methods-are-not-triggered-with-retryable?rq=1


声明周期:
```json
onOpen
hi execute
onError
hi execute
onError
recover:tom
onClose
recovery
```
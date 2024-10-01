<bean id="pipe" class="com.ss.cpe.analytics.Pipe"
		scope="prototype" abstract="true" lazy-init="true">

<bean id="pipeJobParametersToS1A1" parent="pipe" abstract="true">
	<property name="source" ref="iproSolutionAnalytic" />
	<property name="sourceConnectionType" value="INPUT"/>
	<property name="sink" ref="iproSolutionAnalyticStep1Analytic1" />
  </bean>
  
  <bean id="pipeMemberStartToEtlS1A1MemberStart" parent="pipeJobParametersToS1A1">
	<property name="sourceTypeName" ref="SUBJECT_RANGE_START" />
	<property name="sinkTypeName" ref="SUBJECT_RANGE_START" />
  </bean>

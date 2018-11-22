#(a)
A = c(88,79,84,89,81,87,80,78,83,81,83,82,79,86,85,82,85,87,80,85)

B = c(75,77,86,84,80,76,85,79,77,78,78,83,76,80,81,81,78,78,82,80)

qqnorm(A,main = "Sample A", ylab = "Measured Force" )
qqline(A,col="red")

qqnorm(B,main = "Sample B", ylab = "Measured Force" )
qqline(B,col="red")

#(b)
var.test(A,B, conf.level = 0.95)

#(c)
data = data.frame(A,B)
boxplot(data, ylim= c(75,90), ylab = "Force", xlab="Sample", main="Sample Comparison")
t.test(A,B, mu=0, conf=0.99, alt = "great", var.eq = T, paired = F)
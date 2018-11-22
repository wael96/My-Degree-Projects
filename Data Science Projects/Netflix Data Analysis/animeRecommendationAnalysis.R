setwd("C:/Users/Samuel Wong/Desktop/anime-recommendations-database")
getwd()

data_Anime <- read.csv("anime.csv")
print(data_Anime)

data_Rating <- read.csv("rating.csv")
print(data_Anime)

dataR1 = data_Rating[data_Rating$rating!=-1,]

#Num of rated users
library(plyr)
ratedUsersF = count(dataR1, "user_id")
boxplot(ratedUsersF$freq, xlab="Users rated on anime Contents", ylab="Number of Anime Content Rated", 
        main="Boxplot of Number of Anime Content Rated by Users")

summary(ratedUsersF$freq)

mergedD = merge(dataR1,data_Anime, by=c("anime_id"))

barplot(table(data_Anime$type),xlab="Types of Anime Content",ylab="Frequency",
        main="Barplot of th frequencies of different types of anime content in the dataset")
####
ggscatter(mergedD, x="rating.x", y="rating.y", add="reg.line", conf.int=TRUE, cor.coef=TRUE, 
          cor.method = "pearson", xlab="User Rating", ylab="Historical Rating")

sample1 = mergedD[mergedD$anime_id==71,]

plot(mergedD$rating.x, mergedD$rating.y, frame=FALSE)
abline(lm(mergedD$rating.y~mergedD$rating.x, data=mergedD),col="blue")


summary(mergedD$rating.y)
boxplot(mergedD$rating.y, xlab="Historical Ratings", ylab="Rating Score (Max:10)", 
        main="Boxplot of Historical Ratings on Anime Contents")

summary(mergedD$rating.x)
boxplot(mergedD$rating.x, xlab="User Ratings", ylab="Rating Score (Max:10)", 
        main="Boxplot of User Ratings on Anime Contents")


typeMovie = mergedD[mergedD$type=="Movie",]
typeTV = mergedD[mergedD$type=="TV",]
typeMusic = mergedD[mergedD$type=="Music",]
typeONA = mergedD[mergedD$type=="ONA",]
typeOVA = mergedD[mergedD$type=="OVA",]
typeSpecial = mergedD[mergedD$type=="Special",]


boxplot(typeTV$rating.x, typeMovie$rating.x, typeMusic$rating.x, typeONA$rating.x, 
        typeOVA$rating.x, typeSpecial$rating.x, names=c("TV","Movie","Music","ONA","OVA","Special"), 
        ylab="Rating Score (Max:10)", 
        main="Boxplot of User Ratings on different types of Anime Contents")

summary(typeMovie$rating.x)
summary(typeTV$rating.x)
summary(typeMusic$rating.x)
summary(typeONA$rating.x)
summary(typeOVA$rating.x)
summary(typeSpecial$rating.x)

plot(mergedD$rating.x, mergedD$episodes, xlab="User Ratings", ylab="Number of Episodes", frame=FALSE)
abline(lm(mergedD$episodes~mergedD$rating.x, data=mergedD),col="blue")




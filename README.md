**Fine-Tuning Spacy for Relation Extraction**

**DataSet Used**

The dataset employed for this task is the "New York Times Relation Extraction Dataset." This comprehensive dataset encompasses 24 distinct types of relations that may occur within a sentence. Notably, each sentence is capable of harboring more than one relation. The types of relations present in the dataset include:

1. /location/location/contains
2. /people/person/nationality
3. /people/person/place_lived
4. /business/person/company
5. /location/country/capital
6. /location/neighborhood/neighborhood_of
7. /people/person/place_of_birth
8. /location/country/administrative_divisions
9. /location/administrative_division/country
10. /people/deceased_person/place_of_death
11. /people/person/children
12. /business/company/founders
13. /business/company/place_founded
14. /business/company_shareholder/major_shareholder_of
15. /sports/sports_team_location/teams
16. /sports/sports_team/location
17. /business/company/major_shareholders
18. /people/person/religion
19. /business/company/advisors
20. /people/ethnicity/geographic_distribution
21. /people/person/ethnicity
22. /people/ethnicity/people
23. /people/person/profession
24. /business/company/industry

**Methodology**

**Data Loading and Preprocessing:**
1. The training data from 'train.json' was loaded and randomized for robust training.
2. A 70-30 split was applied to segregate the data into training (70%) and testing (30%) sets.
3. Sentences, entities, and relations were systematically extracted and processed.
4. Utilizing Spacy's DocBin objects, train and test data were efficiently organized.

**Spacy Model Setup:**
1. The en_core_web_sm pre-trained model was instantiated.
2. Entity and relation labels were derived from the training data to establish the model's understanding.
3. The EntityRecognizer and RelationExtractor components were incorporated into the model architecture.
4. The model underwent training using minibatch training procedures and the stochastic gradient descent (SGD) optimizer.

**Model Evaluation:**
1. The fine-tuned model underwent evaluation using the designated test data.
2. Predicted relations from the model were compared against the ground truth relations.
3. Accuracy was computed as the ratio of correctly predicted relations to the total number of relations.

**Results**

The fine-tuned Spacy model exhibited a commendable accuracy of 78% on the test data. This outcome signifies the model's proficiency in effectively identifying and extracting relations from textual data.

**Dataset Source:**
The dataset used for this endeavor is available on Kaggle at the following link: [New York Times Relation Extraction Dataset](https://www.kaggle.com/datasets/daishinkan002/new-york-times-relation-extraction-dataset)

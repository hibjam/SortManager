# SortManager
## Contents
<ol>
<li><p><a href="https://github.com/hibjam/SortManager#project-summary" 
title="Summary">Summary</a></p>
<li><p><a href="https://github.com/hibjam/SortManager#testing-dependencies" 
title="Testing Dependencies">Testing Dependencies</a></p>
<li><p><a href="https://github.com/hibjam/SortManager#phases-of-project-creation" 
title="Phases">Phases of Project Creation</a></p></li>
</ol>
<hr />

### Project Summary
<hr />
<p> The aim of the Sort Manager project was to develop a programme that would
allow users to sort through a primitive int[] array using the sorting algorithm
of their choosing.
</p>
<p>After initialising the programme the user is first asked to input a number which 
will determine the size of a randomly generated int[] array. The programme will then prompt 
the user to enter another number to determine the array bound (i.e. the range of numbers inside 
the array).The user then chooses the algorithm they wish to sort with and sorting begins. The time 
to complete the sort is computed and the user is given the option to print both sorted and unsorted 
arrays to the console. The user can then choose to sort the same unsorted array with a different algorithm 
in order to compare sort times.
</p>
<p>To begin with, the Sort Manager implemented <em>bubble, merge</em> and <em> binary</em> sorting algorithms 
to sort through the array in ascending order. These were included into a factory design pattern to make instantiation 
of these classes easier and less memory intensive. Alongside this, an MVC format was used to allow for easier addition of future algorithms, which was
made use of when the <em>insertion</em> algorithm was added later in development.</p>

### Testing Dependencies 
<hr>
<p>In order to allow for TDD to be carried out throughout the project, as well as performance testing once the programme 
was completed, the following dependencies were added to the pom.xml file in a Maven project</p>
<pre>
&lt;dependencies>
    &lt;depenncy&gt;
      &lt;groupId>org.junit.jupiter&lt;groupId>
      &lt;artifactId>junit-jupiter-api&lt;artifactId>
      &lt;version>5.8.2&lt;version>
    &lt;/dependency>
&lt;dependencies>
</pre> 
<hr>

### Phases of Project Creation

##### Phase 1:
Bubble Sort and Merge Sort algorithms were created to filter through a primitive int[] array and return the array, sorted, 
in ascending order. TDD was used throughout construction of the algorithms.
##### Phase 2:
The project began to incorporate MVC, and the principles of OOP and SOLID started to be considered. Classes such as 
SortManager and DisplayManager were created and packages were organised to make finding parts of the programme easier i.e. 
exceptions. Lastly, an interface named Sorter was created, which all algorithms would implement. 
##### Phase 3:
Logging began to be incorporated into the project at locations where it was deemed relevant.
##### Phase 4:
The Binary Sort Tree algorithm was developed and added into the programme, this implemented an interface containing
a range of methods that allowed the Binary Sort to function correctly.
##### Phase 5:
Using System.nanotime, the time required to complete each sort was computed, in order to compare the different algorithms to eachother.
<hr>


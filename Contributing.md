## Dozer
Dozer is a framework for robots built with [WPILib](https://github.com/wpilibsuite) to help write fluent, readable code.

WPILib is a very common library teams competing in the FIRST Robotics Competition use write code for their robots. While WPILib does a great job providing APIs to interface with hardware components, we feel that its provided APIs to manage control flow are woefully inadequate. That's why we made Dozer.

## How to contribute to Dozer

#### **Did you find a bug?**

- **Ensure the bug was not already reported** by searching on GitHub under [Issues](https://github.com/SaintsRobotics/Framework/issues).

* If you're unable to find an open issue addressing the problem, [open a new one](https://github.com/SaintsRobotics/Framework/issues/new). Be sure to include a **title and clear description**, as much relevant information as possible, and a **code sample** demonstrating the expected behavior that is not occurring.

#### **Did you write a patch that fixes a bug?**

* Open a new GitHub pull request with the patch.

* Ensure the PR description clearly describes the problem and solution. Include the relevant issue number if applicable.

* Ensure your pull request follows the pull request guidelines

#### **Did you fix whitespace, format code, or make a purely cosmetic patch?**

* Open a new GitHub pull request, creating as few commits as possible

* Ensure your code follows the pull request guidelines

#### **Do you intend to add a new feature or change an existing one?**

* Suggest your change in the [GitHub issue tracker](https://github.com/SaintsRobotics/Framework/issues/new)

* If feedback is positive, submit a pull request with your code change, following the pull request guidelines.

#### **Do you have questions about the source code?**

* Ask any question about how to use Dozer in the GitHub issue tracker](https://github.com/SaintsRobotics/Framework/issues/new).

#### **How else can I contribute?** 
- We're always open to having people update the [wiki](https://github.com/SaintsRobotics/Framework/wiki)
- In addition, using Dozer in your own robot is a great help. We rely on teams and people like you to [report bugs and provide feedback](https://github.com/SaintsRobotics/Framework/issues/new) to help make Dozer better!

## Contributing Guidelines

#### Code of Conduct
**TODO**

#### Pull Requests
- Pull requests should cover one feature or change and one feature or change only. 
- Generally, they should link to an issue or suggestion from the issue tracker, though trivial changes for formatting or bugfixing do not require an associated issue. 
- Non-trivial pull requests should be from a feature branch onto master. The feature branch should have a name that describes what change is being made.
- The commits in a given pull request should be as few as possible, with each commit message being a clear and complete description of the changes in that commit. Trivial commits, such as one to fix a typo, should be rebased into a descriptive commit before the pull request is created.
- While there is no correct way to write and discuss a pull request, [GitHub's advice on writing pull requests](https://github.com/blog/1943-how-to-write-the-perfect-pull-request) is a great starting point. 

#### Code Style
- Please follow [Google's Java style guide](https://google.github.io/styleguide/javaguide.html) when writing your code

#### Documentation
- Please document your code via Javadocs, per  [Google's Java style guide's section on Javadocs](https://google.github.io/styleguide/javaguide.html#s7-javadoc)
- Please also create a description of the reasons of your change in your pull request message and the associated issue.

#### Tests
- Tests (should hopefully) exist over most of Dozer. It is likely that your pull request will not be reviewed until your code passes these tests.
- If you find an issue with a test, or change Dozer's code in a way that breaks tests, or create new features that do not have test coverage yet, please write tests for your code. It is highly unlikely that pull requests that do not pass tests, break existing tests or do not have test coverage will be accepted.

Dozer is a volunteer project. We encourage you to pitch in and [join the effort](https://github.com/SaintsRobotics/Framework/pull/new/master)!

Thanks! :heart: :heart: :heart:

Saints Robotics

*Lovingly based off the [Ruby on Rails contributing guidelines](https://github.com/rails/rails/blob/master/CONTRIBUTING.md)*
# Navigation elements

## Inventory

| Fragment Class                                                       | Title            | Layout / XML resource     | Top-level? |         Superclass         |
|:---------------------------------------------------------------------|:-----------------|:--------------------------|:----------:|:--------------------------:|
| `PreLoginFragment`*(not built in this phase)                         | (none)           | fragment_pre_login        |     No     |          Fragment          |
| `LoginFragment`*(not built in this phase)                            | Sign In          | fragment_login            |     No     |          Fragment          |
| `GameFragment`                                                       | Play             | fragment_game             |    Yes     |          Fragment          |
| `GameSummaryFragment(a DialogFragment)`* (not built in this phase)   | Game Over        | (none)                    |     No     |          DialogFragment          |
| `HistoryFragment`                                                   | History          | fragment_history          |    Yes     |          Fragment          |
| `BadgesFragment`                                                     | Badges           | fragment_badges           |    Yes     |          Fragment          |
| `ProfileFragment`                                                    | Profile          | fragment_profile          |    Yes     |          Fragment          |
| `SettingsFragment (a PreferenceFragmentCompat)`                      | Settings         | preferences               |     No     | `PreferenceFragmentCompat` |
| `WheelOfChangeFragment (a DialogFragment)`*(not built in this phase) | Wheel of Change  | fragment_wheel_of_change  |     No     |          DialogFragment          |
| `PicturePackagesFragment`*(not built in this phase)                  | Picture Packages | fragment_picture_packages |     No     |          Fragment          |

## Organization

- All fragment classes are either already present in the
  `edu.cnm.deepdive.handsolitaire.app.controller` package, or should be created in that package.
- All referenced layouts are either existing layout resources, existing XML resources, or should be
  created, using a root element of `ConstraintLayout` for Fragment subclasses, and an XML resource
  with a PreferenceScreen root element for PreferenceFragment subclasses.

## Widget

- Top-level navigation will use a `BottomNavigationView` with a `FragmentContainerView`. (BottomNav)

- The menu resource used by the navigation view should be named `main_options`.

## Host

- Navigation controls and controllers should be hosted inside an activity named `MainActivity` using
  a layout resource named `activity_main`.

- Activity classes should reside in the `edu.cnm.deepdive.handsolitaire.app.controller` package.

## Navigation view and fragment synchronization

- Navigation action and state changes will use the Jetpack navigation component, with an
  `AppBarConfiguration` tied to a `NavController`, and the `NavController` tied to a
  `BottomNavigationView`. (non-tabbed)

- Navigation action and display changes will use the `BottomNavigationView` component, driven by a
  `PrimaryTabRow` a `FragmentStateAdapter` subclass.

## General

- View binding will be used in all Fragment subclasses (other than `PreferenceFragmentCompat`.
  subclasses).

- All view binding instance reference properties should be named `binding`. In Kotlin fragments,
  this should be a `lateinit var` property; in Kotlin activities, this should be declared as a `val`
  property, initialized `by lazy`.

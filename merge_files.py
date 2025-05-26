"""
This script merges the contents of two text files.
It can also operate in a "test" mode, which merges predefined sample content.

To run the script:
- For merging files: python merge_files.py <file1_path> <file2_path>
- For test mode: python merge_files.py test
"""

# Predefined sample content for test mode
SAMPLE_FILE1_CONTENT = "This is the content of the first sample file.\n"
SAMPLE_FILE2_CONTENT = "This is the content of the second sample file.\n"

def merge_file_contents(file_path1: str, file_path2: str) -> str:
    """Merges the contents of two specified text files.

    Args:
        file_path1: The path to the first text file.
        file_path2: The path to the second text file.

    Returns:
        A string containing the concatenated content of the two files.
        If either file cannot be found or read, an error message string
        is returned.

    Raises:
        FileNotFoundError: Internally caught and handled, returning an error message string.
    """
    try:
        with open(file_path1, 'r') as f1:
            content1 = f1.read()
    except FileNotFoundError:
        return f"Error: File not found at {file_path1}"

    try:
        with open(file_path2, 'r') as f2:
            content2 = f2.read()
    except FileNotFoundError:
        return f"Error: File not found at {file_path2}"

    return content1 + content2

if __name__ == "__main__":
    # Get user input: two file paths or 'test' for test mode
    user_input = input("Enter two file paths separated by a space, or enter 'test' for test mode: ")

    merged_content = ""
    # Check if the user requested test mode
    if user_input.lower() == "test":
        # In test mode, use the predefined sample content
        merged_content = SAMPLE_FILE1_CONTENT + SAMPLE_FILE2_CONTENT
    else:
        # User provided file paths, attempt to parse them
        file_paths = user_input.split()
        # Check if exactly two file paths were provided
        if len(file_paths) != 2:
            # Generate an error message for incorrect input format
            merged_content = "Error: Please provide exactly two file paths separated by a space, or 'test'."
        else:
            # Call the function to merge the content of the specified files
            merged_content = merge_file_contents(file_paths[0], file_paths[1])

    # Print the final merged content or any error message
    print("\n--- Merged Content ---")
    print(merged_content)
